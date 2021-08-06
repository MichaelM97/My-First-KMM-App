package com.michaelmccormick.myfirstkmmapp.android.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.michaelmccormick.myfirstkmmapp.models.Repository
import com.michaelmccormick.myfirstkmmapp.repositories.GitHubRepository
import kotlinx.coroutines.launch

class SearchViewModel(private val repository: GitHubRepository) : ViewModel() {
    var isLoading by mutableStateOf(false)
        private set
    var searchQuery by mutableStateOf("")
        private set
    var numOfResults by mutableStateOf(0)
        private set
    var results: List<Repository> by mutableStateOf(emptyList())
        private set
    var error: String? by mutableStateOf(null)
        private set

    fun updateSearchQuery(searchQuery: String) {
        this.searchQuery = searchQuery
    }

    fun performSearch() {
        isLoading = true
        viewModelScope.launch {
            try {
                repository.performSearch(searchQuery).let {
                    numOfResults = it.numOfResults
                    results = it.results
                }
            } catch (e: Exception) {
                error = e.message.orEmpty()
            } finally {
                isLoading = false
            }
        }
    }
}
