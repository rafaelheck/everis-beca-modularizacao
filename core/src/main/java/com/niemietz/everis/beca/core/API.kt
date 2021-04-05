package com.niemietz.everis.beca.core

import com.niemietz.everis.beca.core.exceptions.BackendException
import com.google.gson.Gson
import com.niemietz.everis.beca.core.models.ErrorResult
import retrofit2.Call

object API {
    fun <T> response(addAnnouncement: Call<T>): T {
        val newPostResponse = addAnnouncement.execute()

        return when (val statusCode = newPostResponse.code()) {
            200 ->
                newPostResponse.body() ?: run {
                    throw BackendException("Empty response!")
                }
            404 -> throw BackendException("Error $statusCode: Invalid OP Key!")
            else -> {
                val contentType = newPostResponse.raw().header("Content-Type")
                if (contentType?.contains("text/html") == true ||
                    contentType?.contains("text/plain") == true) {
                    throw BackendException("Error $statusCode: ${newPostResponse.raw().message()}")
                } else if (contentType?.contains("application/json") == true) {
                    val error: ErrorResult = Gson().fromJson(
                        newPostResponse.errorBody()?.string(),
                        ErrorResult::class.java
                    )
                    throw BackendException("Error $statusCode: ${error.result}")
                } else {
                    throw BackendException("Error $statusCode: Unknown API error")
                }
            }
        }
    }
}