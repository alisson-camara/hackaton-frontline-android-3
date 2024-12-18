package com.workshop.db.dao

import com.workshop.db.PlayerTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class PlayerDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PlayerDAO>(PlayerTable)

    var name by PlayerTable.name
    var point by PlayerTable.point
    var room by RoomDAO referencedOn PlayerTable.room
}
