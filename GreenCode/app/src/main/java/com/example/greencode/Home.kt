package com.example.greencode

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Home : AppCompatActivity() {


    class MyClass{
        companion object{
            var activity: Activity? = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        MyClass.activity = this@Home
    }

    fun goToMarketplace(v:View){
        val intent = Intent(this, Marketplace::class.java)
        startActivity(intent)
    }

    fun goToQRCode(v:View){
        val intent = Intent(this, QRCodeView::class.java)
        startActivity(intent)
    }
}
