package dev.trindadedev.exp.api.models

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val status: String,
    val total_pages: String,
    val projects: List<Project>
)