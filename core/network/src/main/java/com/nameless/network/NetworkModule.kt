package com.nameless.network

import org.koin.dsl.module

val networkModule = module {
    single<ApiService> { ApiService.build() }
}