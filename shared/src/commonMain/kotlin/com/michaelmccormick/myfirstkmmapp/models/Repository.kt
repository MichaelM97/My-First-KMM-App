package com.michaelmccormick.myfirstkmmapp.models

data class Repository(
    val id: Int = -1,
    val name: String = "",
    val fullName: String = "",
    val owner: RepositoryOwner = RepositoryOwner(),
    val url: String = "",
    val description: String = "",
    val stargazers: Int = 0,
)
