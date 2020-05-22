package com.ptzkg.sharedpreferencecount

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val sharedPrefFile = "SHARED_PREFERENCE_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        val count = sharedPreferences.getInt("pref_count",0)
        txtCount.text = count.toString()

        btnCount.setOnClickListener {
            var count = txtCount.text.toString().toInt()
            count = count+1
            txtCount.text = count.toString()

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putInt("pref_count", count)
            editor.apply()
        }
    }
}
