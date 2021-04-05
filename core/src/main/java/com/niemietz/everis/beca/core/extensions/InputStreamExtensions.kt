package com.niemietz.everis.beca.core.extensions

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

fun <T> InputStream.toObjectFromArray(aClass: Class<T>): ArrayList<T> {
    val list: ArrayList<T> = ArrayList()

    val gson = Gson()
    val arry: JsonArray = JsonParser.parseString(this.parseString()).asJsonArray
    for (jsonElement in arry) {
        list.add(gson.fromJson(jsonElement, aClass))
    }

    return list
}

fun <T> InputStream.toObject(aClass: Class<T>) : T =
    Gson().fromJson(BufferedReader(InputStreamReader(this)), aClass)

fun InputStream.parseString(): String {
    val isReader = InputStreamReader(this)
    val reader = BufferedReader(isReader)
    val sb = StringBuffer()
    reader.forEachLine {line ->
        sb.append(line)
    }

    return sb.toString()
}