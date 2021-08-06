package com.michaelmccormick.myfirstkmmapp.repositories

import com.michaelmccormick.myfirstkmmapp.entities.toModel
import com.michaelmccormick.myfirstkmmapp.network.GitHubAPI

class GitHubRepository {
    private val service: GitHubAPI = GitHubAPI()

    suspend fun performSearch(searchQuery: String) =
        service.searchRepositories(searchQuery).toModel()
}
