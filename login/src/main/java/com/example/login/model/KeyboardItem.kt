package com.example.login.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class KeyboardItem (
    @SerializedName("letter")
    val letter: String,
    @SerializedName("numbers")
    val numbers: ArrayList<Int>
): Parcelable