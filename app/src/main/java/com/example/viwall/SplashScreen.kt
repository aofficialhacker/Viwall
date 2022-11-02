package com.example.viwall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.example.viwall.R.layout.activity_splash_screen
import com.example.viwall.fragments.HomeFragment

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(activity_splash_screen)
        Handler().postDelayed(Runnable {
                                       startActivity(Intent(this,MainActivity::class.java)) //from which activity to which activity user will be transferred
        },2500)     //after this milliesecond user will be redirected to another activity
    }
}