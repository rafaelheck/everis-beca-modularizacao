package com.niemietz.everis.beca.core.extensions

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import kotlin.collections.ArrayList

fun <T> String.toObject(aClass: Class<T>) : T =
    Gson().fromJson(this, aClass)

fun <T> String.toObjectFromArray(aClass: Class<T>): ArrayList<T> {
    val list: ArrayList<T> = ArrayList()

    val gson = Gson()
    val arry: JsonArray = JsonParser.parseString(this).asJsonArray
    for (jsonElement in arry) {
        list.add(gson.fromJson(jsonElement, aClass))
    }

    return list
}