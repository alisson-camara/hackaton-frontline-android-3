package com.workshop.db

import org.jetbrains.exposed.dao.id.IntIdTable

object RoomTable : IntIdTable("room") {
    val name = varchar("name", 50)
    val currentTask = varchar("current_task", 50)
    val moderator = varchar("moderator", 50)
}

object PlayerTable : IntIdTable("player") {
    val name = varchar("name", 50)
    var point = varchar("point", 50)
    val room = reference("room_id", RoomTable)
}
