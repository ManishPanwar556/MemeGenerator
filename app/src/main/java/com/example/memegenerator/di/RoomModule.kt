package com.example.memegenerator.di

import android.content.Context
import androidx.room.Room
import com.example.memegenerator.room.MemeDao
import com.example.memegenerator.room.MemeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {
    @Singleton
    @Provides
    fun provideMemeDb(@ApplicationContext context: Context): MemeDatabase {
        return Room.databaseBuilder(context, MemeDatabase::class.java, MemeDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration().build()
    }
    @Singleton
    @Provides
    fun provideMemeDao(memeDatabase: MemeDatabase):MemeDao{
        return memeDatabase.getRoomDao()
    }
}