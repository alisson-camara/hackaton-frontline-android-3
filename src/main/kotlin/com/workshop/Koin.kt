package com.workshop

import io.ktor.server.application.*

fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger()
        modules(helloAppModule)
    }
}