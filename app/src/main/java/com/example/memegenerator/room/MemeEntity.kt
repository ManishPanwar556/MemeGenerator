package com.example.memegenerator.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memetable")
data class MemeEntity(
    @PrimaryKey(autoGenerate = false)
    val title:String,
    val url:String
)
