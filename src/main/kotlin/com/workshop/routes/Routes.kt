package com.workshop.routes

import com.workshop.repository.IRoomRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class WorkshopRoutes(private val route: Route) : KoinComponent {

    private val repository by inject<IRoomRepository>()

    fun getRoomByName() {
        route.get("/room") {
            val name = call.queryParameters["room"]

            if (name == null) {
                call.respond(HttpStatusCode.BadRequest)
                return@get
            }

            val roomName = repository.getRoomByName(name)
            if (roomName == null) {
                call.respond(HttpStatusCode.NotFound)
                return@get
            }
            call.respond(roomName)
        }
    }

    fun getCreateRoom() {
        route.post("/create-room") {
            val roomName = call.queryParameters["room"]
            val moderator = call.queryParameters["moderator"]

            if (roomName == null || moderator == null) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }

            val room = repository.createRoom(roomName, moderator)
            if (room == null) {
                call.respond(HttpStatusCode.NotFound)
                return@post
            }
            call.respond(room)
        }
    }

    fun removePlayer() {
        route.post("/remove-player") {
            val room = call.queryParameters["room"]
            val player = call.queryParameters["player"]

            if (room == null || player == null) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }

            val roomName = repository.removePlayer(room, player)
            if (roomName == null) {
                call.respond(HttpStatusCode.NotFound)
                return@post
            }
            call.respond(roomName)
        }
    }

    fun resetVotes() {
        route.post("/reset-votes") {
            val room = call.queryParameters["room"]
            val player = call.queryParameters["player"]

            if (room == null || player == null) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }

            val roomName = repository.resetVotes(room, player)
            if (roomName == null) {
                call.respond(HttpStatusCode.NotFound)
                return@post
            }
            call.respond(roomName)
        }
    }

    fun sendVote() {
        route.post("/sendvote") {
            val room = call.queryParameters["room"]
            val player = call.queryParameters["player"]

            if (room == null || player == null) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }

            val roomName = repository.sendVote(room, player)
            if (roomName == null) {
                call.respond(HttpStatusCode.NotFound)
                return@post
            }
            call.respond(roomName)
        }
    }

    fun joinRoom() {
        route.post("/join-room") {
            val room = call.queryParameters["room"]
            val player = call.queryParameters["player"]

            if (room == null || player == null) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }

            val roomName = repository.joinRoom(room, player)
            if (roomName == null) {
                call.respond(HttpStatusCode.NotFound)
                return@post
            }
            call.respond(roomName)
        }
    }
}


