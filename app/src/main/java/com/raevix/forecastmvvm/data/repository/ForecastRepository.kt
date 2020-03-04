package com.raevix.forecastmvvm.data.repository

import androidx.lifecycle.LiveData
import com.raevix.forecastmvvm.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>

}