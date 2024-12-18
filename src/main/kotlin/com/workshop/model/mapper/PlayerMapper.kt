package com.workshop.model.mapper

import com.workshop.db.dao.PlayerDAO
import com.workshop.model.Player

object PlayerMapper {
    fun map(player: PlayerDAO): Player = Player(
        player.name,
        player.point
    )
}