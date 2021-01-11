package com.example.memegenerator.retrofit

import com.example.memegenerator.model.MemeModel
import retrofit2.Call
import retrofit2.http.GET

interface MemeRetrofit {
    @GET("gimme")
    fun getMemes(): Call<MemeModel>
}