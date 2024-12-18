package com.workshop.routes

import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

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

}


