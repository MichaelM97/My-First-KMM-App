package com.michaelmccormick.myfirstkmmapp.entities

import com.michaelmccormick.myfirstkmmapp.models.SearchResult
import kotlinx.serialization.Serializable

@Serializable
internal data class SearchResultResponse(
    val total_count: Int? = null,
    val items: List<RepositoryResponse>? = null,
)

internal fun SearchResultResponse.toModel() =
    SearchResult(
        numOfResults = total_count ?: 0,
        results = items?.map { it.toModel() }.orEmpty(),
    )
