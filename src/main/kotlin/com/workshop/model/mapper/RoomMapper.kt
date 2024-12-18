package com.workshop.model.mapper

import com.workshop.db.RoomDAO
import com.workshop.model.Room
import com.workshop.model.dto.RoomDTO

object RoomMapper {
    fun map(room: RoomDAO): Room = Room(
        name = room.name,
        currentTask = room.currentTask,
        moderator = room.moderator,
        // TODO: Refactor this
        players = room.players.map { player ->
            PlayerMapper.map(player)
        }
    )
}