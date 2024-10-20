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
import dev.trindadedev.exp.ui.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onProjectClicked: (Project) -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val scrollState = rememberScrollState()
    
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopBar(
                title = {
                    Text(stringResource(id = Strings.app_name))
                },
                scrollBehavior = scrollBehavior
            ) 
        }
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .verticalScroll(scrollState)
        ) {
            Sections { onProjectClicked(it) }
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