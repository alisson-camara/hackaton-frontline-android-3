package com.workshop.repository

import com.workshop.db.RoomDAO
import com.workshop.db.RoomTable
import com.workshop.db.suspendTransaction
import com.workshop.model.Room
import com.workshop.model.dto.RoomDTO
import com.workshop.model.mapper.RoomMapper

class RoomRepository : IRoomRepository {

    override suspend fun getRoomByName(name: String): Room? = suspendTransaction {
        val roomWIthPlayers =  RoomDAO
            .find { (RoomTable.name eq name) }
            .limit(1)
            .firstOrNull()?.let { room: RoomDAO ->
                val playersDao = room.players.toList()
                room to playersDao
            }

        return@suspendTransaction roomWIthPlayers?.let { room ->
             RoomMapper.map(room = room.first, players = room.second)

        }
    }

    override suspend fun createRoom(name: String, moderator: String): RoomDTO = suspendTransaction {
        val roomDao = RoomDAO.new {
            this.name = name
            this.moderator = moderator
            this.currentTask = ""
        }
        return@suspendTransaction RoomMapper.mapDaoToDto(roomDao)
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