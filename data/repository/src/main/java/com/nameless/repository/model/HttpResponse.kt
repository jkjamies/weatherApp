package com.nameless.repository.model

/**
 * Http response of generic type containing the [data] and [message] pertaining to calls.
 */
sealed class HttpResponse<R>(val data: R? = null, val message: String? = null) {
    /** Success HttpResponse with contained [data]. */
    class Success<R>(data: R): HttpResponse<R>(data)
    /** Error HttpResponse with no[data] and a [message] representing the reason */
    class Error<R>(message: String, data: R? = null): HttpResponse<R>(data, message)
}