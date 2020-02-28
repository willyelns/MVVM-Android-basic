package com.raevix.forecastmvvm.data

import com.raevix.forecastmvvm.data.response.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "f6019ac34f67e4871ee1f86b73848398"

// http://api.weatherstack.com/current?access_key=f6019ac34f67e4871ee1f86b73848398&query=New%20York

interface ApixuWeatherApiService {

    @GET("current")
    fun getCurrentWeather(
        @Query("query") location: String,
        @Query("lang") languageCode: String = "en",
        @Query("units") units: String = "m"
    ): Deferred<CurrentWeatherResponse>

    companion object {
        operator fun invoke(): ApixuWeatherApiService {
            val requestIntecerptor = Interceptor{ chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestIntecerptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
        }
    }
}