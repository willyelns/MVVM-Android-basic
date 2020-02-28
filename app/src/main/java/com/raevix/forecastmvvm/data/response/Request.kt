package com.raevix.forecastmvvm.data.response


import com.google.gson.annotations.SerializedName

data class Request(
    val language: String, // en
    val query: String, // New York, United States of America
    val type: String, // City
    val unit: String // m
)