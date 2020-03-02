package com.raevix.forecastmvvm.data.network.response

import com.google.gson.annotations.SerializedName
import com.raevix.forecastmvvm.data.db.entity.CurrentWeatherEntry
import com.raevix.forecastmvvm.data.db.entity.Location
import com.raevix.forecastmvvm.data.db.entity.Request


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)