package com.workshop.model.mapper

import com.workshop.db.PlayerDAO
import com.workshop.model.Player

object PlayerMapper {
    fun map(player: PlayerDAO): Player = Player(
        player.name,
        player.point
    )
}