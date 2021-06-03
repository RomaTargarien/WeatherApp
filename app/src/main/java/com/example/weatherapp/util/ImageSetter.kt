package com.example.weatherapp.util

import com.example.weatherapp.R
import com.example.weatherapp.data.weather_modules.Hour

fun returnImageResourse(hour: Hour) =
    when (hour.condition) {
        "clear"  -> R.drawable.sun
        "partly-cloudy" -> R.drawable.sun_cloud
        "cloudy","overcast" -> R.drawable.cloud
        "partly-cloudy-and-light-rain",
            "partly-cloudy-and-rain",
            "overcast-and-rain",
            "cloudy-and-light-rain",
            "overcast-and-light-rain",
            "cloudy-and-rain" -> R.drawable.rain
        "overcast-thunderstorms-with-rain" -> R.drawable.storm
        "overcast-and-wet-snow" -> R.drawable.snow_rain
        "partly-cloudy-and-light-snow",
            "partly-cloudy-and-snow",
            "overcast-and-snow",
            "cloudy-and-light-snow",
            "overcast-and-light-snow",
            "cloudy-and-snow" -> R.drawable.snow
        else -> R.drawable.night_rain
    }