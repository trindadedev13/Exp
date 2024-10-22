package dev.trindadedev.exp.ui.screens.home.components

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

import dev.trindadedev.exp.api.models.Project

@Composable
fun Section(
    label: String,
    projects: List<Project>,
    onProjectClicked: (Project) -> Unit
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
            ProjectsList(
                projects = projects,
                onProjectClicked = { onProjectClicked(it) }
            )
        }
    }
}

@Composable
private fun ProjectsList(
    projects: List<Project>,
    onProjectClicked: (Project) -> Unit
) {
    projects.forEach { project ->
        ElevatedCard(
            Modifier
                .width(100.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(12.dp))
                .clickable { onProjectClicked(project) }
        ) {
            Column {
                AsyncImage(
                    model = project.icon,
                    contentDescription = "Project Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .fillMaxWidth()
                        .height(100.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = project.title,
                    style = MaterialTheme.typography.titleMedium,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.padding(start = 2.dp, end = 2.dp)
                )
                Text(
                    text = project.description,
                    style = MaterialTheme.typography.bodyMedium,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    modifier = Modifier.padding(start = 2.dp, end = 2.dp)
                )
            }
        }
    }
}