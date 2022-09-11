package com.nameless.repository.model

/**
 * Http response of generic type containing the [message] pertaining to calls.
 */
sealed class HttpResponse(val message: String? = null) {
    /** Success HttpResponse. */
    class Success: HttpResponse()
    /** Error HttpResponse with a [message] representing the reason */
    class Error(message: String): HttpResponse(message)
}