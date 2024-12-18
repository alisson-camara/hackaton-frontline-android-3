package com.workshop.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class PlayerDTO(
    val name: String? = "",
    val point: String? = "",
)