package com.michaelmccormick.myfirstkmmapp.entities

import com.michaelmccormick.myfirstkmmapp.models.Repository
import com.michaelmccormick.myfirstkmmapp.models.RepositoryOwner
import kotlin.test.Test
import kotlin.test.assertEquals

internal class RepositoryResponseTest {
    @Test
    fun shouldMapToModel() {
        // Given
        val response = RepositoryResponse(
            id = 9,
            name = "My-First-KMM-App",
            full_name = "MichaelM97/My-First-KMM-App",
            owner = RepositoryOwnerResponse(),
            html_url = "https://github.com/MichaelM97/My-First-KMM-App",
            description = "My first Kotlin Multi Platform app",
            stargazers_count = 999,
        )

        // When
        val model = response.toModel()

        // Then
        assertEquals(
            Repository(
                id = 9,
                name = "My-First-KMM-App",
                fullName = "MichaelM97/My-First-KMM-App",
                owner = RepositoryOwner(),
                url = "https://github.com/MichaelM97/My-First-KMM-App",
                description = "My first Kotlin Multi Platform app",
                stargazers = 999,
            ),
            model,
        )
    }
}
