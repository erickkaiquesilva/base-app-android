package com.example.greencode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_home_page.*
import net.glxn.qrgen.android.QRCode
import org.json.JSONObject
import org.json.JSONStringer
import java.io.Serializable

class HomePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
    }

    fun showQrCodeScreen(V : View){
        val usuario:Usuario = intent.getSerializableExtra("usuario") as Usuario

        createQrCode(usuario)
        qr_code_screen.visibility = View.VISIBLE
    }

    fun hideQrCodeScreen(V : View){
        qr_code_screen.visibility = View.INVISIBLE
    }

    fun createQrCode( usuario:Usuario ){
        val bitmap = QRCode.from(Gson().toJson(usuario)).withSize(1000, 1000).bitmap()
        qr_code.setImageBitmap(bitmap)
    }
}
