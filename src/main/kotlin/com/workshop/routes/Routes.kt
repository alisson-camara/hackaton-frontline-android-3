package com.workshop.routes

import io.ktor.server.response.respondText
import io.ktor.server.routing.*

class WorkshopRoutes(private val route: Route){

    //TODO repo
    fun getRooms(){
        route.get("/room") {
            val text = call.parameters.get("room")
            call.respondText("Hello ${text}")
            //TODO
        }
    }

    fun getCreateRoom(){
        route.get("/create-room") {
//
            call.parameters.get("room")
            //TODO
        }
    }

    fun removePlayer() {
        route.post("/remove-player") {
            // todo
        }
    }

    fun resetVotes() {
        route.post("/reset-votes") {

        }
    }

    fun sendVote() {
        route.post("/sendvote") {

        }
    }

    fun joinRoom() {
        route.post("/join-room") {

        }
    }
}


