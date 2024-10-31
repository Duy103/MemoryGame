package com.memorize.game.zip.utils

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.appsflyer.AppsFlyerLib
import com.appsflyer.attribution.AppsFlyerRequestListener

object TrackingUtils {

    fun logAppsflyerEvent(activity: Activity, eventName: String, params: Bundle) {
        Log.d("ZEUS_Params", "eventName = $eventName")
        val mapParams: Map<String, Any> = bundleToMap(params)
        AppsFlyerLib.getInstance().logEvent(
            activity,
            eventName, mapParams,
            object : AppsFlyerRequestListener {
                override fun onSuccess() {
                    activity.runOnUiThread {
//                        Toast.makeText(activity, "Appsflyer success: $eventName, params = $params", Toast.LENGTH_LONG)
//                            .show()
                    }
                }

                override fun onError(p0: Int, p1: String) {
                    activity.runOnUiThread {
//                        Toast.makeText(activity, "Appsflyer onError: $p1", Toast.LENGTH_LONG).show()
                    }
                }

            }
        )
    }

    private fun bundleToMap(extras: Bundle): Map<String, String> {
        val map: MutableMap<String, String> = HashMap()
        val ks = extras.keySet()
        val iterator: Iterator<String> = ks.iterator()
        while (iterator.hasNext()) {
            val key = iterator.next()
            val value = extras.getString(key) ?: ""

//            Log.d("ZEUS_Params", "[key, value] = [$key, $value]")
            map[key] = value
        }
        return map
    }
}