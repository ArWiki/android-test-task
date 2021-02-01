package com.example.androidtesttask.domain.entities

data class Country(
    val status: String,
    val totalResults: Int,
    val articles: List<CountryArticles>,
) {
    data class CountryArticles(
        val source: CountryArticlesSource,
        val author: String,
        val articles: String,
        val title: String,
        val description: String,
        val url: String,
        val urlToImage: String,
        val publishedAt: String,
        val content: String,
    ) {
        data class CountryArticlesSource(
            val id: String,
            val name: String,
        )
    }
}