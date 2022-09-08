package com.nameless.weatherapp

import android.app.Application
import com.nameless.network.networkModule
import com.nameless.repository.repositoryModule
import com.nameless.weatherdetail.weatherDetailModule
import com.nameless.weatherforecast.weatherForecastModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class WeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@WeatherApp)
            modules(
                networkModule,
                repositoryModule,
                weatherForecastModule,
                weatherDetailModule
            )
        }
    }
}