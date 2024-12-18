package com.workshop.db

import io.ktor.server.application.Application
import io.ktor.server.application.log
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureDatabases(embedded: Boolean) {

    val url = if(embedded) "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1" else environment.config.property("postgres.url").getString()
    log.info("Connecting to postgres database at $url")
    val user = if(embedded) "root" else environment.config.property("postgres.user").getString()
    val password = if(embedded) "" else environment.config.property("postgres.password").getString()

    Database.connect(
        url = url,
        user = user,
        password = password
    )
    transaction {
        SchemaUtils.create(RoomTable)
        SchemaUtils.create(PlayerTable)
    }
}