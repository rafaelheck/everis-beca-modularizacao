package com.niemietz.tccutils.exceptions

class BackendRuntimeException : RuntimeException {
    constructor(message: String): super(message)
    constructor(message: String, ex: Exception?): super(message, ex)
    constructor(ex: Exception): super(ex)
}