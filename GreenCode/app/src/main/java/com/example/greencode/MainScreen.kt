package com.example.greencode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainScreen : AppCompatActivity() {

    var counter = 0
    val message = R.string.back_txt

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        if (counter >= 1) {
            super.onBackPressed() // invocando o comportamento padrão
        } else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            counter++
        }
    }

    fun goToLogin(v:View){
        val intent = Intent(this, SignIn::class.java)
        startActivity(intent)
        finish()
    }

    fun goToSignUp(v:View){
        val intent = Intent(this, Signup::class.java)
        startActivity(intent)
        finish()
    }
}
