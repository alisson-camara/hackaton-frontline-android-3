package com.workshop.di

import com.workshop.repository.IRoomRepository
import com.workshop.repository.RoomRepository
import org.koin.dsl.module

object Dependencies {
    val modules = module {
        factory<IRoomRepository> {
            RoomRepository()
        }
    }
}