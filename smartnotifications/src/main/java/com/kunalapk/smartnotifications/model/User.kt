package com.kunalapk.smartnotifications.model

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class NotificationReportModel(
    var has_tapped: Boolean = false,
    var version: String? = null,
    var created_on: String? = null,
    var tapped_on: String? = null
){
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "has_tapped" to has_tapped,
            "version" to version,
            "created_on" to created_on,
            "tapped_on" to tapped_on
        )
    }
}
