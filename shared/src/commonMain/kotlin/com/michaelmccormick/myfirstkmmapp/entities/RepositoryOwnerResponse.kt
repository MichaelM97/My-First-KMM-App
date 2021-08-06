package com.michaelmccormick.myfirstkmmapp.entities

import com.michaelmccormick.myfirstkmmapp.models.RepositoryOwner
import kotlinx.serialization.Serializable

@Serializable
internal data class RepositoryOwnerResponse(
    val id: Int? = null,
    val avatar_url: String? = null,
)

internal fun RepositoryOwnerResponse.toModel() =
    RepositoryOwner(
        id = id ?: -1,
        avatarUrl = avatar_url.orEmpty(),
    )
