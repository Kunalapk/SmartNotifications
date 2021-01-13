package com.kunalapk.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.kunalapk.smartrecyclerview.helper.NotificationReportHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        FirebaseMessaging.getInstance().subscribeToTopic("admin")

        NotificationReportHelper.updateNotificationReport(intent)
    }
}