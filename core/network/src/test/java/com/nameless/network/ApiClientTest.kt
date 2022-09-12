package com.nameless.network;

import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class ApiClientTest {

    private val engine = MockEngine { request ->
        respond(
            content = ByteReadChannel(MOCK_FORECAST_RESPONSE),
            status = HttpStatusCode.OK,
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }

    @Test
    fun clientSearchCityName() = runBlocking {
        val client = ApiService.build(engine = engine)
        val response = client.getWeatherForecastFromCityName("Detroit")

        // TODO: test a lot more - saving time for now
        assertThat(response?.city?.name, equalTo("Detroit"))
    }

    @Test
    fun clientSearchZipCode() = runBlocking {
        val client = ApiService.build(engine = engine)
        val response = client.getWeatherForecastFromZipCode("48201")

        // TODO: test a lot more - saving time for now
        assertThat(response?.city?.name, equalTo("Detroit"))
    }
}