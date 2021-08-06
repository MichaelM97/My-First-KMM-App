package com.michaelmccormick.myfirstkmmapp.entities

import kotlinx.serialization.Serializable

@Serializable
internal data class RepositoryOwnerResponse(
    val id: Int? = null,
    val avatar_url: String? = null,
)
