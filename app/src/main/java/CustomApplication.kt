package com.niemietz.everis.beca.core

import android.app.Application
import com.niemietz.everis.beca.modularizacao.BuildConfig

class CustomApplication: Application() {
    init {
        BackendClient.setURL(BuildConfig.BECA_API_HOST)
        BackendClient.setTimeout(99999)
    }
}