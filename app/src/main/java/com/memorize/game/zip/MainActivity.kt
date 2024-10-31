package com.memorize.game.zip

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.memorize.game.zip.databinding.ActivityMainBinding
import com.memorize.game.zip.utils.CheckIPUtils

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        val windowInsetsController =
            WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

// Write a message to the database

        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference(packageName.replace(".", "-"))

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                if (value.isNullOrEmpty().not()) {
                    CheckIPUtils.checkIp(object : CheckIPListener {
                        override fun onCountryCallBack(countryCode: String?, countryName: String?) {
                            if (TextUtils.isEmpty(countryCode) ||   TextUtils.isEmpty(countryName)) {
                                return
                            }
                        }
                    })
                }
                myRef.removeEventListener(this)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                // goToGoldMiner();
            }
        })
    }
}