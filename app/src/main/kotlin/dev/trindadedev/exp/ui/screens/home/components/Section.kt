package dev.trindadedev.exp.ui.screens.home.components

import androidx.compose.foundation.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.text.font.*
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
                onProjectClicked = {
                    onProjectClicked(it)
                }
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
        ProjectItem(
            project= project,
            onProjectClicked = {
                onProjectClicked(it)
            }
        )
    }
}

@Composable
private fun ProjectItem(
    project: Project,
    onProjectClicked: (Project) -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .width(100.dp)
            .padding(end = 8.dp)
            .clickable {
                onProjectClicked(project)
            },
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = project.icon,
                contentDescription = "Project Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(0.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = project.title,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Filled.CloudDownload,
                        contentDescription = "Downloads",
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = project.downloads.toString(),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Likes",
                        modifier = Modifier
                            .size(15.dp)
                            .tint(MaterialTheme.colorScheme.onSurfaceVariant)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = project.likes.toString(),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}