package com.example.greencode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignIn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }


    fun goToHomePage(v: View){
        val email = et_email.text.toString()
        val senha = et_password.text.toString()

        val res = LoginTask().execute(Usuario(email = email, senha = senha)).get()

        if(res != null){
            val intent = Intent(this, Home::class.java)
            intent.putExtra("usuario",res)
            startActivity(intent)
            finish()
        }

    }

}
