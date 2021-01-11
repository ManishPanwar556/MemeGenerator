package com.example.memegenerator.room

import androidx.room.*

@Dao
interface MemeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemeToRoom(memeEntity: MemeEntity)
    @Query("SELECT * From memetable")
    suspend fun getMemeFromRoom():List<MemeEntity>
    @Query("Delete from memetable")
    suspend fun delete()

}