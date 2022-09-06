package com.nameless.network

object ApiRoutes {
    // get your own! =) note: this one is dead, so don't bother trying to use it
    const val API_KEY = "7737e6c2d472f9a042573213e9452413"
    // defaultRequest could also work in ApiService within the client
    const val BASE_URL = "https://api.openweathermap.org/data/2.5"
    // possibly could use just "forecast", or omit and use in base url if using defaultRequest
    const val FORECAST = "/forecast?"
    // simpler area to append api key
    private fun String.appendApiKey() = "${this@appendApiKey}&appid=$API_KEY"
    // getter for forecast route
    fun getForecastRoute(lat: Double, lon: Double) = "${BASE_URL}${FORECAST}lat=$lat&lon=$lon".appendApiKey()
}