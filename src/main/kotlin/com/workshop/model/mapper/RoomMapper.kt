package com.workshop.model.mapper

import com.workshop.db.dao.PlayerDAO
import com.workshop.db.dao.RoomDAO
import com.workshop.model.dto.RoomDTO

object RoomMapper {
    fun mapDaoToDto(room: RoomDAO, players: List<PlayerDAO>?) = RoomDTO(
        name = room.name,
        currentTask = room.currentTask,
        moderator = room.moderator,
        players = if (players.isNullOrEmpty().not()) players?.map { PlayerMapper.map(it) } else null
    )
}