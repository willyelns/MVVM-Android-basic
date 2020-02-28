package com.raevix.forecastmvvm.data.response


import com.google.gson.annotations.SerializedName

data class CurrentWeatherEntry(
    val cloudcover: Int, // 0
    val feelslike: Int, // -3
    val humidity: Int, // 36
    @SerializedName("is_day")
    val isDay: String, // yes
    @SerializedName("observation_time")
    val observationTime: String, // 03:24 PM
    val precip: Int, // 0
    val pressure: Int, // 1012
    val temperature: Int, // 1
    @SerializedName("uv_index")
    val uvIndex: Int, // 3
    val visibility: Int, // 16
    @SerializedName("weather_code")
    val weatherCode: Int, // 113
    @SerializedName("weather_descriptions")
    val weatherDescriptions: List<String>,
    @SerializedName("weather_icons")
    val weatherIcons: List<String>,
    @SerializedName("wind_degree")
    val windDegree: Int, // 250
    @SerializedName("wind_dir")
    val windDir: String, // WSW
    @SerializedName("wind_speed")
    val windSpeed: Int // 13
)