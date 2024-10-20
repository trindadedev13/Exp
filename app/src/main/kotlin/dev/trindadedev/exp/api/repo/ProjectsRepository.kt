package dev.trindadedev.exp.api.repo

import dev.trindadedev.exp.api.models.Project
import dev.trindadedev.exp.api.Consts.URL
import dev.trindadedev.exp.api.Consts.Routes.PROJECTS_ROUTES

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.Parameters

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ProjectsRepository(
    private val httpClient: HttpClient,
    private val json: Json
) {

    suspend fun getProjects(apiKey: String): List<Project> {
        val urlWithParams = "$URL$PROJECTS_ROUTES?api_key=$apiKey"
        val response: HttpResponse = httpClient.get(urlWithParams)

        if (response.status.value in 200..299) {
            val responseBody: String = response.body()
            return json.decodeFromString(responseBody)
        } else {
            throw Exception("error lol: ${response.status}")
        }
    }
}