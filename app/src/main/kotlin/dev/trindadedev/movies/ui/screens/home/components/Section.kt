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

import coil3.compose.AsyncImage

import dev.trindadedev.movies.mv.models.Movie

@Composable
fun Section(
    label: String,
    movies: List<Movie>
) {
    val vScrollState = rememberScrollState()
    val hScrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(vScrollState)
    ){
        Text(
            text = label,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(8.dp)
        )
        Row(
            modifier = Modifier.horizontalScroll(hScrollState)
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
        Row(
            Modifier
                .fillMaxWidth()
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