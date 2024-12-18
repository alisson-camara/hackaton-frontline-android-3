package com.workshop.model.mapper

import com.workshop.model.Room
import com.workshop.model.dto.RoomDTO

object RoomMapper {
    fun map(room: Room): RoomDTO = RoomDTO(
        name = room.name.orEmpty(),
        currentTask = room.currentTask.orEmpty(),
        moderator = room.moderator.orEmpty(),
        players = room.players.map { player ->
            PlayerMapper.map(player)
        }
    )
}