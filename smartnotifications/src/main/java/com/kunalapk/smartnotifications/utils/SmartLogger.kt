package com.kunalapk.smartnotifications.utils

import android.util.Log
import com.kunalapk.smartnotifications.BuildConfig

object SmartLogger {
    private var TAG = javaClass.simpleName

    fun verbose(tag: String, msg: String) {
        if (BuildConfig.DEBUG)
            Log.v(tag, msg)
    }

    fun debug(tag: String, msg: String) {
        if (BuildConfig.DEBUG)
            Log.d(tag, msg)
    }

    fun info(tag: String, msg: String) {
        if (BuildConfig.DEBUG)
            Log.i(tag, msg)
    }

    fun warn(tag: String, msg: String) {
        if (BuildConfig.DEBUG)
            Log.w(tag, msg)
    }

    fun error(tag: String, msg: String) {
        if (BuildConfig.DEBUG)
            Log.e(tag, msg)
    }
}