package com.niemietz.everis.beca.core

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

object InternetChecker {
    fun isConnected2Internet(context: Context, testMode: Boolean = false): Boolean {
        if (testMode) {
            return true
        }

        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT < 23) {
            val ni = cm.activeNetworkInfo
            if (ni != null) {
                return ni.isConnectedOrConnecting &&
                (ni.type == ConnectivityManager.TYPE_WIFI ||
                ni.type == ConnectivityManager.TYPE_MOBILE ||
                ni.type == ConnectivityManager.TYPE_ETHERNET)
            }
        } else {
            val n = cm.activeNetwork
            if (n != null) {
                val nc = cm.getNetworkCapabilities(n)
                nc?.let {
                    return it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                    it.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
                }
            }
        }

        return false
    }
}