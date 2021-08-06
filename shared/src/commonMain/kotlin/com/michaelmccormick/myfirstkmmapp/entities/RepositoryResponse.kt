package com.michaelmccormick.myfirstkmmapp.entities

import com.michaelmccormick.myfirstkmmapp.models.Repository
import com.michaelmccormick.myfirstkmmapp.models.RepositoryOwner
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

internal fun RepositoryResponse.toModel() =
    Repository(
        id = id ?: -1,
        name = name.orEmpty(),
        fullName = full_name.orEmpty(),
        owner = owner?.toModel() ?: RepositoryOwner(),
        url = html_url.orEmpty(),
        description = description.orEmpty(),
        stargazers = stargazers_count ?: 0,
    )
