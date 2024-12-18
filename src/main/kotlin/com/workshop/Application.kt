package com.workshop

import com.workshop.repository.FakeTaskRepository
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    //val repository = PostgresTaskRepository()
    val taskRepository = FakeTaskRepository()
    configureSerialization(taskRepository)
    configureDatabases()
    configureRouting()
}
