package com.kunalapk.smartrecyclerview.helper

import android.content.Intent
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.kunalapk.smartnotifications.model.NotificationReportModel
import com.kunalapk.smartnotifications.utils.SmartLogger
import com.kunalapk.smartnotifications.utils.SmartNotificationsConstants
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

object NotificationReportHelper {

    fun createNotificationReportToFirestore(uuid:String?,campaign_name:String?,version:String?){
        if(campaign_name!=null && uuid!=null){
            try{
                val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                val currentDateandTime: String = sdf.format(Date())

                SmartLogger.debug("NotificationReportHelper - ", "Adding data to campaign")
                val database  = Firebase.database.reference
                val notificationReportModel = NotificationReportModel(has_tapped = false, version = version,created_on = currentDateandTime)
                database.child(campaign_name).child(uuid).setValue(notificationReportModel)
            }catch (e: Exception){
                e.printStackTrace()
            }
        }else{
            SmartLogger.debug("NotificationReportHelper - ", "Null values found in campaign")
        }

    }

    fun updateNotificationReport(intent: Intent?){
        val campaign_name = intent?.extras?.getString(SmartNotificationsConstants.KEY_NOTIFICATION_REPORT_CAMPAIGN_NAME)
        val uuid = intent?.extras?.getString(SmartNotificationsConstants.KEY_NOTIFICATION_REPORT_UUID)

        if(campaign_name!=null && uuid!=null){
            updateNotificationReport(uuid,campaign_name)
        }
    }

    fun updateNotificationReport(uuid:String,campaign_name:String){
        try{
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val currentDateandTime: String = sdf.format(Date())

            val database  = Firebase.database.reference
            database.child(campaign_name).child(uuid).apply {
                child(SmartNotificationsConstants.KEY_HAS_TAPPED).setValue(true)
                child(SmartNotificationsConstants.KEY_TAPPED_ON).setValue(currentDateandTime)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

}