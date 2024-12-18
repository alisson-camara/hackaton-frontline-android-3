package com.workshop.repository

import com.workshop.model.Room

interface IRoomRepository {
    suspend fun getRoomByName(name: String): Room?
    suspend fun createRoom(name: String, moderator: String): Room?
    suspend fun removePlayer(room: String, player: String): Room?
    suspend fun resetVotes(room: String, player: String): Room?
    suspend fun sendVote(room: String, player: String): Room?
    suspend fun joinRoom(room: String, player: String): Room?
}