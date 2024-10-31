package com.memorize.game.zip.utils

import android.util.Log
import com.memorize.game.zip.CheckIPListener
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

object CheckIPUtils {

    fun checkIp(listener: CheckIPListener) {
        Thread {
            val urlV2: URL
            try {
                urlV2 = URL("https://api.db-ip.com/v2/free/self/")
                val connV2 = urlV2.openConnection() as HttpURLConnection
                connV2.connectTimeout = 60000 // timing out in a minute
                val inV2 =
                    BufferedReader(InputStreamReader(connV2.inputStream))
                var str: String?
                val result = StringBuilder()
                while (inV2.readLine().also { str = it } != null) {
                    result.append(str)
                }
                Log.d("ZEYS", "result = $result")
                inV2.close()
                val jsonObject = JSONObject(result.toString())
                var countryCode: String? = ""
                var countryName: String? = ""
                if (jsonObject.has("countryCode")) {
                    countryCode = jsonObject.getString("countryCode")
                }
                if (jsonObject.has("countryName")) {
                    countryName = jsonObject.getString("countryName")
                }
                listener.onCountryCallBack(countryCode, countryName)
            } catch (e: Exception) {
                throw RuntimeException(e)
            }
        }.start()
    }
}