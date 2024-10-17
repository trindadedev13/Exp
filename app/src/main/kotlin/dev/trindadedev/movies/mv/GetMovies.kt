package dev.trindadedev.movies.mv

import dev.trindadedev.movies.mv.models.Movie

fun getMovies(type: Type): List<Movie> {
    if (type == Type.LATEST) {
        return getLatestMovies()
    }
    return emptyList()
}

private fun getLatestMovies(): List<Movie> {
    return listOf(
        Movie(
            id = 0,
            name = "Aquiles Trindade, A História.",
            description= "The man's life story",
            image = "https://github.com/trindadedev13.png",
            categoryName = Type.LATEST.toName,
            url = "bruh"
        ),
        Movie(
            id = 0,
            name = "Aquiles Trindade, A História.",
            description= "The man's life story",
            image = "https://github.com/trindadedev13.png",
            categoryName = Type.LATEST.toName,
            url = "bruh"
        ),
        Movie(
            id = 0,
            name = "Aquiles Trindade, A História.",
            description= "The man's life story",
            image = "https://github.com/trindadedev13.png",
            categoryName = Type.LATEST.toName,
            url = "bruh"
        )
    )
}