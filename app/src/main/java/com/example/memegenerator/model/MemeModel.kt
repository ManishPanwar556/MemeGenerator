package com.example.memegenerator.model


import com.squareup.moshi.Json

data class MemeModel(
    @Json(name = "author")
    val author: String,
    @Json(name = "nsfw")
    val nsfw: Boolean,
    @Json(name = "postLink")
    val postLink: String,
    @Json(name = "preview")
    val preview: List<String>,
    @Json(name = "spoiler")
    val spoiler: Boolean,
    @Json(name = "subreddit")
    val subreddit: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "ups")
    val ups: Int,
    @Json(name = "url")
    val url: String
)