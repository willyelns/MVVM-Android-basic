package com.raevix.forecastmvvm.data.db.entity


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "current_weather_location")
data class Location(
    val country: String, // United States of America
    val lat: String, // 40.714
    val localtime: String, // 2020-02-28 10:24
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int, // 1582885440
    val lon: String, // -74.006
    val name: String, // New York
    val region: String, // New York
    @SerializedName("timezone_id")
    val timezoneId: String, // America/New_York
    @SerializedName("utc_offset")
    val utcOffset: String // -5.0
)