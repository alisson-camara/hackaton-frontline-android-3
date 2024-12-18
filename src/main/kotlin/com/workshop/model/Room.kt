package com.workshop.model

data class Room(
    val name: String? = "",
    val currentTask: String? = "",
    val moderator: String? = "",
    val players: List<Player> = listOf()
)
