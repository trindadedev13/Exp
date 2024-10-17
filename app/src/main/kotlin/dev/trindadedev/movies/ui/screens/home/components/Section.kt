package dev.trindadedev.movies.ui.screens.home.components

import androidx.compose.foundation.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.text.style.*

import coil3.compose.AsyncImage

import dev.trindadedev.movies.mv.models.Movie

@Composable
fun Section(
    label: String,
    movies: List<Movie>
) {
    val scrollState = rememberScrollState()
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(8.dp)
        )
        Row(
            modifier = Modifier.horizontalScroll(scrollState)
        ) {
            MoviesList(movies)
        }
    }
}

@Composable
private fun MoviesList(
    movies: List<Movie>
) {
    movies.forEach { movie ->
        Column(
            Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(8.dp)
        ) {
            AsyncImage(
                model = movie.image,
                contentDescription = "Movie Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .width(100.dp)
                    .height(100.dp)
            )
            Text(
                text = movie.name,
                style = MaterialTheme.typography.titleMedium,
                //overflow = TextOverflow.Ellipsis
            )
            Text(
                text = movie.description,
                style = MaterialTheme.typography.bodyMedium,
                //overflow = TextOverflow.Ellipsis
            )
        }
    }
}