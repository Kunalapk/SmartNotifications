package com.kunalapk.smartrecyclerview.helper

import android.content.Context
import com.kunalapk.smartnotifications.managers.SharedPreferencesManager
import com.kunalapk.smartnotifications.services.NotificationSharedPrefConstant

object NotificationSharedPreferencesHelper {
    private var TAG = javaClass.simpleName

    fun getProfileName(context: Context): String? = SharedPreferencesManager.with(context = context)!!.getString(
        NotificationSharedPrefConstant.STORE_PROFILE_NAME, "")

    fun storeProfileName(context: Context,installId: String) {
        SharedPreferencesManager.with(context)!!.edit().putString(NotificationSharedPrefConstant.STORE_PROFILE_NAME, installId).apply()
    }

    fun getProfileLastName(context: Context): String? = SharedPreferencesManager.with(context = context)!!.getString(NotificationSharedPrefConstant.STORE_PROFILE_LAST_NAME, "")

    fun storeProfileLastName(context: Context,installId: String) {
        SharedPreferencesManager.with(context)!!.edit().putString(NotificationSharedPrefConstant.STORE_PROFILE_LAST_NAME, installId).apply()
    }

    fun getProfileFullName(context: Context): String? = SharedPreferencesManager.with(context = context)!!.getString(NotificationSharedPrefConstant.STORE_PROFILE_FULL_NAME, "")

    fun storeProfileFullName(context: Context,installId: String) {
        SharedPreferencesManager.with(context)!!.edit().putString(NotificationSharedPrefConstant.STORE_PROFILE_FULL_NAME, installId).apply()
    }

}