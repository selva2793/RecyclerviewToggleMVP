package com.selvamani.recyclerviewmvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import java.io.IOException

class FirebasePushNotificationActivity : AppCompatActivity() {
    private val TAG = "MyFirebaseToken"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_push_notification)
        initView()
    }

    private fun initView() {
        //This method will use for fetching Token
        Thread(Runnable {
            try {
                Log.i(TAG, FirebaseInstanceId.getInstance().getToken(getString(R.string.SENDER_ID), "FCM"))
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }).start()
    }
}