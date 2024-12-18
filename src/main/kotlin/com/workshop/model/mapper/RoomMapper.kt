package com.workshop.model.mapper

import com.workshop.db.PlayerDAO
import com.workshop.db.RoomDAO
import com.workshop.model.Room
import com.workshop.model.dto.RoomDTO

object RoomMapper {
    fun map(room: RoomDAO, players: List<PlayerDAO>): Room = Room(
        name = room.name,
        currentTask = room.currentTask,
        moderator = room.moderator,
        players = players.map { player ->
            PlayerMapper.map(player)
        }
    )
}