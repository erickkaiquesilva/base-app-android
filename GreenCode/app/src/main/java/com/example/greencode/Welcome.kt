package com.example.greencode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Welcome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }

    fun goToFirstAccess(v:View){
        val intent = Intent(this, FirstAccess::class.java)
        intent.putExtra("usuarioLogado", getIntent().getSerializableExtra("usuarioLogado"))
        startActivity(intent)
        finish()
    }
}
