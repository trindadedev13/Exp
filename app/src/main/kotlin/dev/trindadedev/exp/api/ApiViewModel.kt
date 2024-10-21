package dev.trindadedev.exp.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import dev.trindadedev.exp.BuildConfig
import dev.trindadedev.exp.api.models.Project
import dev.trindadedev.exp.api.repo.ProjectsRepository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ApiViewModel(
    private val repo: ProjectsRepository
) : ViewModel() {

    private val _projects = MutableStateFlow<List<Project>>(emptyList())
    val projects: StateFlow<List<Project>> get() = _projects

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error
    
    init {
        fetchProjects(BuildConfig.SKETCHUB_API_KEY)
    }

    fun fetchProjects(apiKey: String) {
        viewModelScope.launch {
            try {
                _projects.value = repo.getProjects(apiKey)
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }
}