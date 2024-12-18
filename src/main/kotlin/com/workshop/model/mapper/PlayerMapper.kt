package com.workshop.model.mapper

import com.workshop.model.Player
import com.workshop.model.dto.PlayerDTO

object PlayerMapper {
    fun map(player: Player): PlayerDTO = PlayerDTO(
        player.name,
        player.point
    )
}