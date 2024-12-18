package com.workshop

import com.workshop.config.configureKoin
import com.workshop.config.configureSerialization
import com.workshop.db.configureDatabases
import com.workshop.routes.configureRouting
import io.ktor.server.application.Application

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureDatabases(true)
    configureKoin()
    configureRouting()
}
