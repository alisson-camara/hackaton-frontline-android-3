package com.workshop.db.dao

import com.workshop.db.PlayerTable
import com.workshop.db.RoomTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class RoomDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RoomDAO>(RoomTable)

    var name by RoomTable.name
    var currentTask by RoomTable.currentTask
    var moderator by RoomTable.moderator
    val players by PlayerDAO referrersOn PlayerTable.room
}
