package dev.trindadedev.exp.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val image: String = "",
    val categoryName: String = "",
    val url: String = ""
)