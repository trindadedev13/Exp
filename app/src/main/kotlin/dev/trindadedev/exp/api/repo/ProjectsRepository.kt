package dev.trindadedev.exp.api.repo

import android.util.Log

import dev.trindadedev.exp.api.models.Project
import dev.trindadedev.exp.api.Consts.URL
import dev.trindadedev.exp.api.Consts.Routes.PROJECTS_ROUTE

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.client.engine.android.*

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ProjectsRepository(
    private val httpClient: HttpClient
) {
    suspend fun getProjects(apiKey: String): List<Project> {
        val response: HttpResponse = httpClient.submitForm(
            url = "$URL$PROJECTS_ROUTE",
            formParameters = parameters {
                append("api_key", apiKey)
            }
        )
        
        Log.d("ProjectsRepository::getProjectsL31", response.body())
        val json = Json { ignoreUnknownKeys = true }
        
        if (response.status.value in 200..299) {
            val responseBody: String = response.body()
            return json.decodeFromString(responseBody)
        } else {
            throw Exception("error lol: ${response.status}")
        }
    }
}
