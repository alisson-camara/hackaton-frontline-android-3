package com.workshop.config

import com.workshop.di.Dependencies
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun Application.configureKoin() {
    install(Koin) {
        modules(Dependencies.modules)
    }
}