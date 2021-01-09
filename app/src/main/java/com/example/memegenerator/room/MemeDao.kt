package com.example.memegenerator.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MemeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemeToRoom(memeEntity: MemeEntity)
    @Query("SELECT * From memetable")
    suspend fun getMemeFromRoom():List<MemeEntity>
}