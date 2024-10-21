package dev.trindadedev.exp.api

import dev.trindadedev.exp.BuildConfig

object Consts {

    const val URL = "https://sketchub.in/api/v3/"
    
    object Routes {
        const val PROJECTS_ROUTE = "get_project_list"
    }
    
    object Tokens {
        const val API_KEY = BuildConfig.SKETCHUB_API_KEY
    }
}