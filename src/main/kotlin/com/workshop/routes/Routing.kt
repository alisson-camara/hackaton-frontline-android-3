package com.workshop.routes

import com.workshop.routes.WorkshopRoutes.getCreateRoom
import com.workshop.routes.WorkshopRoutes.getRoomByName
import com.workshop.routes.WorkshopRoutes.joinRoom
import com.workshop.routes.WorkshopRoutes.removePlayer
import com.workshop.routes.WorkshopRoutes.resetVotes
import com.workshop.routes.WorkshopRoutes.sendVote
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }
    routing {
        getRoomByName()
        getCreateRoom()
        removePlayer()
        joinRoom()
        resetVotes()
        sendVote()
        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}
