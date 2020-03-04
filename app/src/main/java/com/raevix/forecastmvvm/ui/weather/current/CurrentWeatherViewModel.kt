package com.raevix.forecastmvvm.ui.weather.current

import androidx.lifecycle.ViewModel
import com.raevix.forecastmvvm.data.repository.ForecastRepository
import com.raevix.forecastmvvm.internal.UnitSystem
import com.raevix.forecastmvvm.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {
    private val unitSystem =  UnitSystem.METRIC // get from settings later
    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }
}
