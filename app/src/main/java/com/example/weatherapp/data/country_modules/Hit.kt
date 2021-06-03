package com.example.weatherapp.data.country_modules

data class Hit(
    val city: String,
    val country: String,
    val countrycode: String,
    val extent: List<Double>,
    val house_number: String,
    val housenumber: String,
    val name: String,
    val osm_id: Int,
    val osm_key: String,
    val osm_type: String,
    val osm_value: String,
    val point: Point,
    val postcode: String,
    val state: String,
    val street: String
)