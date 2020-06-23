package com.example.greencode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_product.*

class Product : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val product_image = intent.extras!!.getInt("product_image")
        val product_name = intent.extras!!.getString("product_name")
        val product_valor = intent.extras!!.getString("product_valor")
        val product_obs = intent.extras!!.getString("product_obs")
        setContentView(R.layout.activity_product)
        ivProduct.setImageResource(product_image)
        tvtextao.text = product_obs
        tvProductName.text = product_name
        tvValueGreen.text = product_valor
    }

    fun  backToMarketplace(v:View){
        onBackPressed()
        finish()
    }

    fun gastarPontos(v:View){
        val usuario = intent.getSerializableExtra("usuarioLogado") as Usuario
        val pontos = tvValueGreen.text.toString().toInt()

        if(usuario.pontos!! > pontos) {

            val novosPontos = usuario.pontos!! - pontos

            usuario.pontos = novosPontos

            val trocou = AtualizarPontosTask().execute(usuario).get()

            if(trocou){

                val res = EnviarCuponTask().execute(usuario).get()

                val intent = Intent(this, Cupom::class.java)
                intent.putExtra("usuarioLogado", usuario)
                startActivity(intent)
                finish()

            }else{
                Toast.makeText(this,"Não foi posivel fazer a troca ¬¬, Desculpe",Toast.LENGTH_LONG).show()
            }

        }else{
            Toast.makeText(this,"Você não tem pontos suficientes, Recicle + :)",Toast.LENGTH_LONG).show()
        }

    }
}
