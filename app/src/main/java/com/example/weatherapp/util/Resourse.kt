package com.example.weatherapp.util

sealed class Resourse<T>(val data: T? = null,val message: String? = null) {
    class Success<T>(data: T?): Resourse<T>(data)
    class Error<T>(message: String?): Resourse<T>(null,message)
    class Loading<T>(): Resourse<T>()
}
