package dev.trindadedev.movies.mv.models

data class Movie(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val categoryName: String,
    val url: String
)