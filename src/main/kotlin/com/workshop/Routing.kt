package com.workshop

import com.workshop.model.PlayerModel
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.sql.Connection
import java.sql.DriverManager
import org.jetbrains.exposed.sql.*

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause" , status = HttpStatusCode.InternalServerError)
        }
    }
    routing {
        get("/players") {
            call.respond(listOf(
                PlayerModel("Player 1", "1"),
                PlayerModel("Player 2", "2"),
                PlayerModel("Player 3", "3"),
                PlayerModel("Player 4", "4")
            )
            )
        }
        get("/") {
            call.respondText("Hello World!")
        }
        post("/sendvote") {
            val receivedValue = call.receiveText()
            call.respondText { receivedValue }
        }
        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}
