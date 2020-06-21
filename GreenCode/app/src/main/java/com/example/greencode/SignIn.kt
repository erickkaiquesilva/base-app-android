package com.example.greencode

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignIn : AppCompatActivity() {

    var preferencias:SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        preferencias = getPreferences(Context.MODE_PRIVATE)

        val email = preferencias?.getString("email","")
        val senha = preferencias?.getString("senha", "")
        val salvado = preferencias?.getBoolean("salvado", false)

        if (salvado != null) {
            switch_btn.isChecked = salvado
        }

        if(switch_btn.isChecked) {
            et_email.setText(email)
            et_password.setText(senha)
        }
    }


    fun goToHomePage(v: View){

        val email = et_email.text.toString()
        val senha = et_password.text.toString()

        if (switch_btn.isChecked){
            val editor = preferencias?.edit()

            editor?.putString("email", email)
            editor?.putString("senha", senha)
            editor?.putBoolean("salvado", true)

            editor?.commit()
        }

        val usuario = LoginTask().execute(Usuario(email = email, senha = senha)).get()

        if(usuario != null){
            val intent = Intent(this, Home::class.java)
            val intent2 = Intent(this, Product::class.java)
            intent.putExtra("usuarioLogado",usuario)
            intent2.putExtra("usuarioLogado",usuario)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this,"Email ou Login Incorretos",Toast.LENGTH_SHORT).show()
        }

    }

}
