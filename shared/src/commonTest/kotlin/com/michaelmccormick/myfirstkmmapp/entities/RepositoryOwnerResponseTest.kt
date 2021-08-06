package com.michaelmccormick.myfirstkmmapp.entities

import com.michaelmccormick.myfirstkmmapp.models.RepositoryOwner
import kotlin.test.Test
import kotlin.test.assertEquals

internal class RepositoryOwnerResponseTest {
    @Test
    fun shouldMapToModel() {
        // Given
        val response = RepositoryOwnerResponse(
            id = 12,
            avatar_url = "www.my_avatar.com",
        )

        // When
        val model = response.toModel()

        // Then
        assertEquals(
            RepositoryOwner(
                id = 12,
                avatarUrl = "www.my_avatar.com",
            ),
            model,
        )
    }
}
