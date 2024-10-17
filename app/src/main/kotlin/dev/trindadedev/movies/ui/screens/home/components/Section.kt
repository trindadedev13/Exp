package dev.trindadedev.movies.ui.screens.home.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.layout.*

import coil.compose.AsyncImage

import dev.trindadedev.movies.mv.models.Movie

@Composable
fun Section(
    label: String,
    movies: List<Movie>
) {
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.titleLarge
        )
        MoviesList(movies)
    }
}

@Composable
private fun MoviesList(
    movies: List<Movie>
) {
    movies.forEach { movie ->
        Row(Modifier.fillMaxWidth()) {
            AsyncImage(
                model = movie.image,
                contentDescription = "Movie Image",
                contentScale = ContentScale.Crop
            )
            
            Column {
                Text(
                    text = movie.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = movie.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}