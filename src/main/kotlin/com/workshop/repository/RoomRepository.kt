package com.workshop.repository

import com.workshop.db.PlayerTable
import com.workshop.db.RoomTable
import com.workshop.db.dao.PlayerDAO
import com.workshop.db.dao.RoomDAO
import com.workshop.model.dto.RoomDTO
import com.workshop.model.mapper.RoomMapper
import com.workshop.utils.suspendTransaction
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.update

class RoomRepository : IRoomRepository {

    override suspend fun getRoomByName(name: String): RoomDTO? = suspendTransaction {
        val roomWIthPlayers = RoomDAO
            .find { (RoomTable.name eq name) }
            .limit(1)
            .firstOrNull()?.let { room: RoomDAO ->
                val playersDao = room.players.toList()
                room to playersDao
            }

        return@suspendTransaction roomWIthPlayers?.let { room ->
            RoomMapper.mapDaoToDto(room = room.first, players = room.second)
        }
    }

    override suspend fun createRoom(name: String, moderator: String): RoomDTO = suspendTransaction {
        val roomDao = RoomDAO.new {
            this.name = name
            this.moderator = moderator
            this.currentTask = "Task 1"
        }

        val playersDao = roomDao.players.toList()
        return@suspendTransaction RoomMapper.mapDaoToDto(roomDao, playersDao)
    }

    override suspend fun removePlayer(room: String, player: String) = suspendTransaction {
        val roomWIthPlayers = RoomDAO
            .find { (RoomTable.name eq player) }
            .limit(1)
            .firstOrNull()?.let { room: RoomDAO ->
                val playersDao = room.players.toList()
                room to playersDao
            }

        return@suspendTransaction roomWIthPlayers?.let { room ->
            PlayerTable.deleteWhere {
                (this.name eq player) and (RoomTable.id eq this.room)
            }
            RoomMapper.mapDaoToDto(room = room.first, players = room.second)
        }
    }

    override suspend fun resetVotes(room: String, player: String): RoomDTO? {
        val roomDao = RoomDAO
            .find { (RoomTable.name eq room) }
            .limit(1)
            .firstOrNull() ?: return null

        if (roomDao.moderator != player) {
            return null
        }

        val players = roomDao.players.toList()

        players.forEach { it.point = "?" }

        return RoomMapper.mapDaoToDto(roomDao, players)
    }

    override suspend fun sendVote(room: String, player: String, point: String): RoomDTO? = suspendTransaction {

        val roomDao = RoomDAO
            .find { (RoomTable.name eq room) }
            .limit(1)
            .firstOrNull() ?: return@suspendTransaction null

        val players = roomDao.players.toList()

        players.first { it.name == player }.point = point

        return@suspendTransaction RoomMapper.mapDaoToDto(roomDao, players)
    }

    override suspend fun joinRoom(room: String, player: String): RoomDTO? = suspendTransaction{

        val currentRoom = RoomDAO
            .find { (RoomTable.name eq room) }
            .limit(1).firstOrNull()

        if(currentRoom == null){
            return@suspendTransaction null
        }

        PlayerDAO.new {
            this.name = player
            this.point = "?"
            this.room = currentRoom
        }

        val currentRoomUpdated = RoomDAO
            .find { (RoomTable.name eq room) }
            .limit(1).firstOrNull()

        val playersDao = currentRoomUpdated?.players?.toList()
        return@suspendTransaction RoomMapper.mapDaoToDto(currentRoomUpdated!!, playersDao)
    }
}