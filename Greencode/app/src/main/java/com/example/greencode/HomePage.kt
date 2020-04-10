package com.example.greencode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
    }

    fun showQrCodeScreen(V : View){
        qr_code_screen.visibility = View.VISIBLE
    }

    fun hideQrCodeScreen(V : View){
        qr_code_screen.visibility = View.INVISIBLE
    }
}
