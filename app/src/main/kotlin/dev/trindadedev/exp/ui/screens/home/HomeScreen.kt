package dev.trindadedev.exp.ui.screens.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.input.nestedscroll.*

import dev.trindadedev.exp.Strings
import dev.trindadedev.exp.api.getProjects
import dev.trindadedev.exp.api.Type
import dev.trindadedev.exp.api.models.Project
import dev.trindadedev.exp.ui.screens.home.components.Section

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val scrollState = rememberScrollState()
    
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopBar(scrollBehavior = scrollBehavior) 
        }
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .verticalScroll(scrollState)
        ) {
            Sections { project ->
                // when project clicked
            }
        }
    }
}

@Composable
private fun Sections(
    onProjectClicked: (Project) -> Unit
) {
    Section(
        label = Type.EDITORS_CHOICE.toName, 
        projects = getProjects(Type.EDITORS_CHOICE),
        onProjectClicked = { onProjectClicked(it) }
    )

    Section(
        label = Type.RECENT.toName,
        projects = getProjects(Type.RECENT),
        onProjectClicked = { onProjectClicked(it) }
    )
    
    Section(
        label = Type.MOST_DOWNLOADED.toName,
        projects = getProjects(Type.MOST_DOWNLOADED),
        onProjectClicked = { onProjectClicked(it) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(scrollBehavior: TopAppBarScrollBehavior) {
    TopAppBar(
        title = { Text(text = stringResource(id = Strings.app_name)) },
        scrollBehavior = scrollBehavior,
    )
}
