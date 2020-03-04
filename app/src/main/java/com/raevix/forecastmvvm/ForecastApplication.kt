package com.raevix.forecastmvvm

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import com.raevix.forecastmvvm.data.ApixuWeatherApiService
import com.raevix.forecastmvvm.data.db.ForecastDatabase
import com.raevix.forecastmvvm.data.network.ConnectivityInterceptor
import com.raevix.forecastmvvm.data.network.ConnectivityInterceptorImpl
import com.raevix.forecastmvvm.data.network.WeatherNetworkDataSource
import com.raevix.forecastmvvm.data.network.WeatherNetworkDataSourceImpl
import com.raevix.forecastmvvm.data.repository.ForecastRepository
import com.raevix.forecastmvvm.data.repository.ForecastRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import org.kodein.di.generic.instance

class ForecastApplication: Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { return@singleton instance<ForecastDatabase>().currentWeatherDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApixuWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}