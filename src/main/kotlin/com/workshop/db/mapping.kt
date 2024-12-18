package com.workshop.db

import com.workshop.model.Priority
import com.workshop.model.Task
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

object TaskTable : IntIdTable("task") {
    val name = varchar("name", 50)
    val description = varchar("description", 50)
    val priority = varchar("priority", 50)
}

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

class RoomDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RoomDAO>(RoomTable)

    var name by RoomTable.name
    var currentTask by RoomTable.currentTask
    var moderator by RoomTable.moderator
    val players by PlayerDAO referrersOn PlayerTable.room
}

class PlayerDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PlayerDAO>(PlayerTable)

    var name by PlayerTable.name
    var point by PlayerTable.point
    var room by RoomDAO referencedOn PlayerTable.room
}

class TaskDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TaskDAO>(TaskTable)

    var name by TaskTable.name
    var description by TaskTable.description
    var priority by TaskTable.priority
}

suspend fun <T> suspendTransaction(block: Transaction.() -> T): T =
    newSuspendedTransaction(Dispatchers.IO, statement = block)

fun daoToModel(dao: TaskDAO) = Task(
    dao.name,
    dao.description,
    Priority.valueOf(dao.priority)
)