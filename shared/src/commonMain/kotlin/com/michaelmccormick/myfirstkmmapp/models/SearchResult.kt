package com.michaelmccormick.myfirstkmmapp.models

data class SearchResult(
    val numOfResults: Int = 0,
    val results: List<Repository> = emptyList(),
)
