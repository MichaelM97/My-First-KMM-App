package com.michaelmccormick.myfirstkmmapp.entities

import kotlinx.serialization.Serializable

@Serializable
internal data class RepositoryResponse(
    val id: Int? = null,
    val name: String? = null,
    val full_name: String? = null,
    val owner: RepositoryOwnerResponse? = null,
    val html_url: String? = null,
    val description: String? = null,
    val stargazers_count: Int? = null,
)
