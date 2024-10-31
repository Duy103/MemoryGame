package com.memorize.game.zip

import android.app.Application
import android.util.Log
import com.appsflyer.AppsFlyerLib
import com.appsflyer.attribution.AppsFlyerRequestListener
import com.google.firebase.FirebaseApp

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        AppsFlyerLib.getInstance()
            .start(applicationContext, "bLsK5uGJLB3SEXvBUcr5v", object : AppsFlyerRequestListener {
                override fun onSuccess() {
                    Log.d("ZEUS", "Launch sent successfully, got 200 response code from server")
                }

                override fun onError(i: Int, s: String) {
                    Log.d("ZEUS", "Launch failed to be sent:" + "Error code: " + i + "" + "Error description: " + s)
                }
            })
    }
}