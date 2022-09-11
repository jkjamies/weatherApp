package com.nameless.network

object ApiRoutes {
    // get your own! =) note: this one is dead, so don't bother trying to use it
    private const val API_KEY = "7737e6c2d472f9a042573213e9452413"
    // defaultRequest could also work in ApiService within the client
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5"
    // possibly could use just "forecast", or omit and use in base url if using defaultRequest
    private const val FORECAST = "/forecast?"
    // simpler area to append api key
    private fun String.appendApiKey() = "${this@appendApiKey}&appid=$API_KEY"

    // getter for forecast route
    fun getCoordinatesForecastRoute(lat: Double, lon: Double) =
        "${BASE_URL}${FORECAST}lat=$lat&lon=$lon".appendApiKey()
    // getter for forecast by zip route
    fun getZipForecastRoute(zip: String, countryCode: String = "us") =
        "${BASE_URL}${FORECAST}zip=$zip,$countryCode".appendApiKey()
    // getter for forecast by city name route
    fun getCityNameForecastRoute(city: String) =
        "${BASE_URL}${FORECAST}q=$city".appendApiKey()
}