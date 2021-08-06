package com.michaelmccormick.myfirstkmmapp.entities

import com.michaelmccormick.myfirstkmmapp.models.Repository
import com.michaelmccormick.myfirstkmmapp.models.SearchResult
import kotlin.test.Test
import kotlin.test.assertEquals

internal class SearchResultResponseTest {
    @Test
    fun shouldMapToModel() {
        // Given
        val response = SearchResultResponse(
            total_count = 55,
            items = listOf(RepositoryResponse(id = 1), RepositoryResponse(id = 2)),
        )

        // When
        val model = response.toModel()

        // Then
        assertEquals(
            SearchResult(
                numOfResults = 55,
                results = listOf(Repository(id = 1), Repository(id = 2)),
            ),
            model,
        )
    }
}
