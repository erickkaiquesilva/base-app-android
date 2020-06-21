package com.example.greencode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup.*

class Signup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }

    fun goToWelcome(v:View){

        val nome = et_name.text.toString()
        val sobrenome = et_surname.text.toString()
        val cpf = et_id.text.toString()
        val email = et_email.text.toString()
        val senha = et_password.text.toString()



        val usuario = CadastrarUsuarioTask().execute(Usuario(nome = nome, sobrenome = sobrenome,cpf = cpf,
                                                   email = email,senha = senha)).get()

        if(usuario != null){
            val intent = Intent(this, Welcome::class.java)
            val intent2 = Intent(this, Product::class.java)
            intent.putExtra("usuarioLogado",usuario)
            intent2.putExtra("usuarioLogado",usuario)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this,"Erro ao cadastrar", Toast.LENGTH_SHORT)
        }

    }

}
