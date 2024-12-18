package com.workshop.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class RoomDTO(
    val name: String? = "",
    val currentTask: String? = "",
    val moderator: String? = "",
    val players: List<PlayerDTO> = listOf()
)
