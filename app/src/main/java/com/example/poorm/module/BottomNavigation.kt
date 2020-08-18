package com.example.poorm.module

import android.app.ActionBar
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.poorm.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigation : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.menu_community -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_dictionary -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_home -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_market -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_settings -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    lateinit var toolbar : ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        //toolbar = supportActionBar!!
        val bottomNavigation : BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}