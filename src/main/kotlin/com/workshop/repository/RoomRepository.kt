package com.workshop.repository

import com.workshop.model.Room

class RoomRepository(
    // TODO: private val service: RoomService
) : IRoomRepository {
    override suspend fun getRoomByName(name: String): Room {
        TODO("Not yet implemented")
    }

    override suspend fun createRoom(name: String, moderator: String): Room {
        TODO("Not yet implemented")
    }

    override suspend fun removePlayer(room: String, player: String): Room? {
        TODO("Not yet implemented")
    }

    override suspend fun resetVotes(room: String, player: String): Room? {
        TODO("Not yet implemented")
    }

    override suspend fun sendVote(room: String, player: String): Room? {
        TODO("Not yet implemented")
    }

    override suspend fun joinRoom(room: String, player: String): Room? {
        TODO("Not yet implemented")
    }
}