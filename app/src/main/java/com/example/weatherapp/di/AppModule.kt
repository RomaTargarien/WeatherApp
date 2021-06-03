package com.example.weatherapp.di

import com.example.weatherapp.data.CountryApi
import com.example.weatherapp.data.WeatherApi
import com.example.weatherapp.main.IMainRepository
import com.example.weatherapp.main.MainRepository
import com.example.weatherapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideWeatherApi(): WeatherApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_WEATHER_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherApi::class.java)

    @Singleton
    @Provides
    fun provideCountryApi(): CountryApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_COUNTRY_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CountryApi::class.java)

    @Singleton
    @Provides
    fun provideMainRepository(countryApi: CountryApi,weatherApi: WeatherApi):
            IMainRepository = MainRepository(countryApi, weatherApi)
}










