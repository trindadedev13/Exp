package dev.trindadedev.exp.api

import dev.trindadedev.exp.api.models.Project

// for now fake methods

fun getProjects(type: Type): List<Project> {
    if (type == Type.RECENT) {
        return getRecentProjects()
    }
    return getRecentProjects()
}

private fun getRecentProjects(): List<Project> {
    return listOf(
        Project(
            id = 0,
            name = "Aquiles Trindade, A História.",
            description= "The man's life story",
            image = "https://github.com/trindadedev13.png",
            categoryName = Type.RECENT.toName,
            url = "bruh"
        ),
        Project(
            id = 0,
            name = "Aquiles Trindade, A História.",
            description= "The man's life story",
            image = "https://github.com/trindadedev13.png",
            categoryName = Type.RECENT.toName,
            url = "bruh"
        ),
        Project(
            id = 0,
            name = "Aquiles Trindade, A História.",
            description= "The man's life story",
            image = "https://github.com/trindadedev13.png",
            categoryName = Type.RECENT.toName,
            url = "bruh"
        )
    )
}