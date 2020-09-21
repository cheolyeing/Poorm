package com.example.poorm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.poorm.home.HomePlantList

class Splash : AppCompatActivity() {

    private val LOADING_TIME: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            Thread.sleep(LOADING_TIME)
            val nextIntent: Intent = Intent(this, HomePlantList::class.java)
            startActivity(nextIntent)
            finish()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}