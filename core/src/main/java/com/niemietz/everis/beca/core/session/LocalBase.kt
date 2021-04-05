package com.niemietz.everis.beca.core.session

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.niemietz.everis.beca.core.extensions.toObject
import com.niemietz.everis.beca.core.extensions.toObjectFromArray
import com.niemietz.everis.beca.core.constants.Constants.SHARED_PREFERENCES_ID

class LocalBase {
    private lateinit var sharedPreferenceEditor: SharedPreferences

    fun <T> save(key: String, value: Any, aClass: Class<T>? = null): Boolean {
        var result = false

        if (::sharedPreferenceEditor.isInitialized) {
            val editor = sharedPreferenceEditor.edit()

            when (aClass) {
                String::class.java -> {
                    editor.putString(key, value as String)
                }
                Int::class.java -> {
                    editor.putInt(key, value as Int)
                }
                Float::class.java -> {
                    editor.putFloat(key, value as Float)
                }
                Long::class.java -> {
                    editor.putLong(key, value as Long)
                }
                Boolean::class.java -> {
                    editor.putBoolean(key, value as Boolean)
                }
                else -> {
                    editor.putString(
                        key,
                        Gson().toJson(
                            value
                        )
                    )
                }
            }

            result = editor.commit()
        }

        return result
    }

    fun <T> get (key: String, aClass: Class<T>, isArray: Boolean = false): Any? {
        var result: Any? = null

        if (::sharedPreferenceEditor.isInitialized) {
            val preferences = sharedPreferenceEditor

            when (aClass) {
                String::class.java -> {
                    result = preferences.getString(key, null)
                }
                Int::class.java -> {
                    result = preferences.getInt(key, -1)
                }
                Float::class.java -> {
                    result = preferences.getFloat(key, -1f)
                }
                Long::class.java -> {
                    result = preferences.getLong(key, -1)
                }
                Boolean::class.java -> {
                    result = preferences.getBoolean(key, false)
                }
                else -> {
                    result = if (isArray) {
                        preferences.getString(key, "[]")?.toObjectFromArray(aClass)
                    } else {
                        preferences.getString(key, "")?.toObject(aClass)
                    }
                }
            }
        }

        return result
    }

    fun remove(key: String): Boolean {
        var result = false

        if (::sharedPreferenceEditor.isInitialized) {
            val preferences = sharedPreferenceEditor.edit()
            preferences.remove(key)
            result = preferences.commit()
        }

        return result
    }

    companion object {
        @JvmStatic
        fun newInstance(context: Context) =
            LocalBase().apply {
                sharedPreferenceEditor =
                    context.getSharedPreferences(
                        SHARED_PREFERENCES_ID,
                        Context.MODE_PRIVATE
                    )
            }
    }
}