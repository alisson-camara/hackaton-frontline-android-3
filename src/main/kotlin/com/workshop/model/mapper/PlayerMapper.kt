package com.workshop.model.mapper

import com.workshop.db.dao.PlayerDAO
import com.workshop.model.dto.PlayerDTO

object PlayerMapper {
    fun map(player: PlayerDAO) = PlayerDTO(
        player.name,
        player.point
    )
}