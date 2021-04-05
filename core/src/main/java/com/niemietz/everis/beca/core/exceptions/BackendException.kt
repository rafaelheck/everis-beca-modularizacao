package com.niemietz.everis.beca.core.exceptions

class BackendException : Exception {
    constructor(message: String): super(message)
    constructor(message: String, ex: Throwable?): super(message, ex)
    constructor(ex: Throwable): super(ex)
}