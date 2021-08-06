package com.michaelmccormick.myfirstkmmapp.network

import com.michaelmccormick.myfirstkmmapp.entities.SearchResultResponse
import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

internal class GitHubAPI {
    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun searchRepositories(searchQuery: String): SearchResultResponse {
        return httpClient.get(SEARCH_ENDPOINT) {
            headers {
                append(HttpHeaders.Accept, ACCEPT_HEADER)
                parameter(SEARCH_QUERY_KEY, searchQuery)
            }
        }
    }

    companion object {
        private const val ENDPOINT = "https://api.github.com"
        private const val SEARCH_ENDPOINT = "$ENDPOINT/search/repositories"
        private const val ACCEPT_HEADER = "application/vnd.github.v3+json"
        private const val SEARCH_QUERY_KEY = "q"
    }
}
