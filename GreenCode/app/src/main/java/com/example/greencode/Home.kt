package com.example.greencode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val usuario = getIntent().getSerializableExtra("usuarioLogado") as Usuario
        user_points.text = usuario.pontos.toString()
        user_name.text = usuario.nome
        user_name_congrats.text = "${usuario.nome} ${usuario.sobrenome}"

    }

    fun goToMarketplace(v:View){
        val intent = Intent(this, Marketplace::class.java)
        startActivity(intent)
    }

    fun goToQRCode(v:View){
        val intent = Intent(this, QRCodeView::class.java)
        intent.putExtra("usuarioLogado",getIntent().getSerializableExtra("usuarioLogado"))
        startActivity(intent)
    }
}
