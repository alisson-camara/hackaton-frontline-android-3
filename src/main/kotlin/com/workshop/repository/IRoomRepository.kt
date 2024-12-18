package com.workshop.repository

import com.workshop.model.dto.RoomDTO

interface IRoomRepository {
    suspend fun getRoomByName(name: String): RoomDTO?
    suspend fun createRoom(name: String, moderator: String): RoomDTO?
    suspend fun removePlayer(room: String, player: String): RoomDTO?
    suspend fun resetVotes(room: String, player: String): RoomDTO?
    suspend fun sendVote(room: String, player: String): RoomDTO?
    suspend fun joinRoom(room: String, player: String): RoomDTO?
}