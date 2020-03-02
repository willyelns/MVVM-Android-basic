package com.raevix.forecastmvvm.data.db.entity


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "current_weather_request")
data class Request(
    val language: String, // en
    val query: String, // New York, United States of America
    val type: String, // City
    val unit: String // m
)