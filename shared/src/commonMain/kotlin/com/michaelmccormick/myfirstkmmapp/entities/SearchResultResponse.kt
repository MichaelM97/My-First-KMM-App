package com.michaelmccormick.myfirstkmmapp.entities

import kotlinx.serialization.Serializable

@Serializable
internal data class SearchResultResponse(
    val total_count: Int? = null,
    val items: List<RepositoryResponse>? = null,
)
