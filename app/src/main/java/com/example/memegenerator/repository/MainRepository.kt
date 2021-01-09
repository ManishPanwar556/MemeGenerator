package com.example.memegenerator.repository

import com.example.memegenerator.retrofit.MemeRetrofit
import com.example.memegenerator.room.MemeDao
import com.example.memegenerator.room.MemeEntity
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val memeDao:MemeDao,
    private val memeRetrofit: MemeRetrofit
) {
    suspend fun getMeme():List<MemeEntity>{
        val meme=memeRetrofit.getMemes()
        val memeEntity=MemeEntity(meme.title,meme.url)
        memeDao.insertMemeToRoom(memeEntity)
        return memeDao.getMemeFromRoom()
    }
}