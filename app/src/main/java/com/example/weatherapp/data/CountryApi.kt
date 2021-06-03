package com.example.weatherapp.data

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.data.country_modules.Country
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CountryApi {

    @GET("geocode?locale=de&debug=true")
    suspend fun getCountry(
        @Query("q") query: String = "berlin",
        @Query("key") key: String = BuildConfig.COUNTRY_API_KEY
    ) : Response<Country>
}