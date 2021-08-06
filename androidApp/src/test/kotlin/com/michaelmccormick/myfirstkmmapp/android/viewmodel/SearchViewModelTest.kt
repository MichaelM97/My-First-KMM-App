package com.michaelmccormick.myfirstkmmapp.android.viewmodel

import com.michaelmccormick.myfirstkmmapp.models.Repository
import com.michaelmccormick.myfirstkmmapp.models.SearchResult
import com.michaelmccormick.myfirstkmmapp.repositories.GitHubRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExperimentalCoroutinesApi
@ExtendWith(CoroutinesTestExtension::class)
internal class SearchViewModelTest {
    private val mockRepository: GitHubRepository = mockk()
    private lateinit var viewModel: SearchViewModel

    @BeforeEach
    fun before() {
        viewModel = SearchViewModel(mockRepository)
    }

    @Test
    fun `Should update search query`() {
        // Given
        assert(viewModel.searchQuery.isEmpty())
        val searchQuery = "Test"

        // When
        viewModel.updateSearchQuery(searchQuery = searchQuery)

        // Then
        assert(viewModel.searchQuery == searchQuery)
    }

    @Test
    fun `Should set results on successful search`() {
        // Given
        assert(viewModel.numOfResults == 0)
        assert(viewModel.results.isEmpty())
        val numOfResults = 3
        val results = listOf(
            Repository(id = 1),
            Repository(id = 2),
            Repository(id = 3),
        )
        coEvery { mockRepository.performSearch(any()) } returns SearchResult(numOfResults, results)

        // When
        viewModel.performSearch()

        // Then
        assert(viewModel.numOfResults == numOfResults)
        assert(viewModel.results == results)
    }

    @Test
    fun `Should set error on failed search`() {
        // Given
        assert(viewModel.error == null)
        val errorMessage = "Kaboom"
        coEvery { mockRepository.performSearch(any()) } throws Exception(errorMessage)

        // When
        viewModel.performSearch()

        // Then
        assert(viewModel.error == errorMessage)
    }
}
