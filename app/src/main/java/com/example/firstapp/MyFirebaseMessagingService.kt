package com.example.firstapp

import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService:FirebaseMessagingService() {

    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
        Log.d("MyFirebaseMessagingService","Got new notification")
        if (p0.data.isNotEmpty()){
            Toast.makeText(this,"DATA: ${p0.data}",Toast.LENGTH_LONG).show()
        }
    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
        Log.d("MyFirebaseMessagingService","New Token: $p0")
    }
}