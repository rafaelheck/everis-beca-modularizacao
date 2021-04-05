package com.niemietz.everis.beca.core.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ErrorResult (
    @SerializedName("result")
    val result: String
): Parcelable