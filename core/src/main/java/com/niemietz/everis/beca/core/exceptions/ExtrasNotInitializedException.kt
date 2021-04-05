package com.niemietz.everis.beca.core.exceptions

import com.niemietz.everis.beca.core.constants.Constants.EXTRAS_EXCEPTION_MESSAGE
import kotlin.reflect.KClass

class ExtrasNotInitializedException: Exception {
    constructor(message: String = EXTRAS_EXCEPTION_MESSAGE): super(message)
    constructor(message: String = EXTRAS_EXCEPTION_MESSAGE, ex: Throwable?): super(message, ex)
    constructor(ex: Throwable): super(ex)

    private val sb = StringBuilder()

    init {
        sb.append(message)
    }

    inner class Builder {
        private var extrasCounter = COUNTER_INITIAL_VALUE

        fun <T> addExtra(key: String? = null, _class: KClass<T>) where T: Any {
            if (extrasCounter > COUNTER_INITIAL_VALUE) {
                sb.append(" + ")
            }
            sb.append(_class.simpleName)
            key?.let {
                sb.append(" with key \"$it\"")
            }
            extrasCounter++
        }

        fun build(): ExtrasNotInitializedException {
            extrasCounter = COUNTER_INITIAL_VALUE

            return ExtrasNotInitializedException(sb.toString())
        }
    }

    companion object {
        private const val COUNTER_INITIAL_VALUE = 0
    }
}