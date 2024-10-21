package dev.trindadedev.exp

import android.app.Application

import dev.trindadedev.exp.di.moduleApp
import dev.trindadedev.exp.di.moduleNetwork

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ExpApp : Application() {

    override fun onCreate() {
        super.onCreate()
        configureKoin()
    }

    fun configureKoin() {
        startKoin {
            //androidLogger()
            androidContext(this@ExpApp)
            modules(moduleApp, moduleNetwork)
        }
    }
}
