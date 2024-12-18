package com.workshop.repository

import com.workshop.db.RoomDAO
import com.workshop.db.RoomTable
import com.workshop.model.Room
import com.workshop.model.mapper.RoomMapper

class RoomRepository : IRoomRepository {

    override suspend fun getRoomByName(name: String): Room? {
        RoomDAO
            .find { (RoomTable.name eq name) }
            .limit(1)
            .map(RoomMapper::map)
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