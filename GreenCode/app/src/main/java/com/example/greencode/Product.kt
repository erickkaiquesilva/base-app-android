package com.example.greencode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_product.*

class Product : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
    }


    fun gastarPontos(v:View){
        val usuario = intent.getSerializableExtra("usuarioLogado") as Usuario
        val pontos = tvValueGreen.text.toString().toInt()

        if(usuario.pontos!! > pontos) {

            usuario.pontos?.minus(pontos)

            val trocou = AtualizarPontosTask().execute(usuario).get()

            if(trocou){
                val res = EnviarCuponTask().execute(usuario.email).get()
            }else{
                Toast.makeText(this,"Não foi posivel fazer a troca ¬¬, Desculpe",Toast.LENGTH_LONG)
            }

        }else{
            Toast.makeText(this,"Você não tem pontos suficientes, Recicle + :)",Toast.LENGTH_LONG)
        }

    }
}
