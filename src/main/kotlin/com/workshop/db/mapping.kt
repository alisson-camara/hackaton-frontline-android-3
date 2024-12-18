package com.workshop.db

import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

object RoomTable : IntIdTable("room") {
    val name = varchar("name", 50)
    val currentTask = varchar("current_task", 50)
    val moderator = varchar("moderator", 50)
}

object PlayerTable : IntIdTable("player") {
    val name = varchar("name", 50)
    val point = varchar("current_task", 50)
    val room = reference("room_id", RoomTable)
}
