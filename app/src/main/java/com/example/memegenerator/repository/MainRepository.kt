package com.example.memegenerator.repository

import com.example.memegenerator.model.MemeModel
import com.example.memegenerator.retrofit.MemeRetrofit
import com.example.memegenerator.room.MemeDao
import com.example.memegenerator.room.MemeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val memeDao:MemeDao,
    private val memeRetrofit: MemeRetrofit
) {
    suspend fun getMeme():List<MemeEntity>{
        val res=memeRetrofit.getMemes()
        res.enqueue(object : Callback<MemeModel>{
            override fun onResponse(call: Call<MemeModel>, response: Response<MemeModel>) {
                if(response.isSuccessful){
                    val title=response.body()?.title
                    val url=response.body()?.url
                    if(url!=null&&title!=null){
                        val memeEntity=MemeEntity(title,url)
                        GlobalScope.launch(Dispatchers.IO) {
                            memeDao.insertMemeToRoom(memeEntity)
                        }

                    }
                }
            }

            override fun onFailure(call: Call<MemeModel>, t: Throwable) {

            }

        })
        return memeDao.getMemeFromRoom()
    }
}