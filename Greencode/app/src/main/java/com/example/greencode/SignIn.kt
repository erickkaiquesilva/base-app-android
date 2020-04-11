package com.example.greencode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignIn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }

    fun Login(v : View){

        val email = email.text.toString()
        val senha = password.text.toString()



        if(email != "" && senha != "" ) {
            val intent = Intent(this, HomePage::class.java)

            intent.putExtra("email", email.toString())
            intent.putExtra("senha", senha.toString())

            startActivity(intent)
            finish()
        }
        else{
            erro_message.text = "Email ou senha Incorreto."
        }
    }
}
