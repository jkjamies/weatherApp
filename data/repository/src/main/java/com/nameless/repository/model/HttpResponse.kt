package com.nameless.repository.model

sealed class HttpResponse<R>(val data: R? = null, val message: String? = null) {
    class Success<R>(data: R): HttpResponse<R>(data)
    class Error<R>(message: String, data: R? = null): HttpResponse<R>(data, message)
}