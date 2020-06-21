package com.example.greencode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Cupom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cupom)
    }

    fun backToHome(v:View){
        Home.MyClass.activity!!.finish()
        val intent = Intent(this, Home::class.java)
        intent.putExtra("usuarioLogado", getIntent().getSerializableExtra("usuarioLogado"))
        startActivity(intent)
        finish()
    }
}