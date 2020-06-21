package com.example.greencode

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import kotlinx.android.synthetic.main.activity_q_r_code.*
import net.glxn.qrgen.android.QRCode
import com.google.gson.JsonObject
import org.json.JSONObject
import org.json.JSONStringer

class QRCodeView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q_r_code)

        val usuario = getIntent().getSerializableExtra("usuarioLogado") as Usuario

        val json = JsonObject()
        json.addProperty("email", usuario.email)
        json.addProperty("senha", usuario.senha)

        generateQrCode(json)

    }

    fun generateQrCode(login: JsonObject){
        val gson = Gson()
        val bitmap = QRCode.from(gson.toJson(login)).withSize(280, 280).withColor(0xFF26BF4C.toInt(), 0xFFFFFF).bitmap()
        qrcode_view.setImageBitmap(bitmap)
    }

    fun backToHome(v:View){
        onBackPressed()
    }
}
