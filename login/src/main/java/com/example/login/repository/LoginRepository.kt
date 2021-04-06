package com.example.login.repository

import com.example.login.interfaces.LoginAPI
import com.example.login.model.AuthenticateRequest
import com.example.login.model.GETSessionRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginRepository(private val api: LoginAPI) {
    suspend fun getSession(request: GETSessionRequest) =
        withContext(Dispatchers.IO) {
            api.getSession(request)
        }

    suspend fun authenticate(request: AuthenticateRequest) =
        withContext(Dispatchers.IO) {
            api.authenticate(request)
        }
}