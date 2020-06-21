package com.example.greencode

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import kotlinx.android.synthetic.main.activity_q_r_code.*
import net.glxn.qrgen.android.QRCode


class QRCodeView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q_r_code)

        generateQrCode("Ver se Fica Verdinho")

    }

    fun generateQrCode(text: String){

        val bitmap = QRCode.from(text).withSize(280, 280).withColor(0xFF26BF4C.toInt(), 0xFFFFFF).bitmap()
        qrcode_view.setImageBitmap(bitmap)
    }

    fun backToHome(v:View){
        onBackPressed()
    }
}
