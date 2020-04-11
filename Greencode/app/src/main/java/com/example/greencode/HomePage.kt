package com.example.greencode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_home_page.*
import net.glxn.qrgen.android.QRCode

class HomePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
    }

    fun showQrCodeScreen(V : View){
        createQrCode("{ email: teste@teste, senha:teste}")
        qr_code_screen.visibility = View.VISIBLE
    }

    fun hideQrCodeScreen(V : View){
        qr_code_screen.visibility = View.INVISIBLE
    }

    fun createQrCode( usuario:String ){
        val gson = Gson()
        val bitmap = QRCode.from(gson.toJson(usuario)).withSize(1000, 1000).bitmap()
        qr_code.setImageBitmap(bitmap)
    }
}
