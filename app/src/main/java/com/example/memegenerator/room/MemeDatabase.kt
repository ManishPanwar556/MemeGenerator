package com.example.memegenerator.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MemeEntity::class],version = 1)
abstract class MemeDatabase:RoomDatabase() {

    abstract fun getRoomDao():MemeDao
    companion object{
        const val DATABASE_NAME="meme_db"
    }
}