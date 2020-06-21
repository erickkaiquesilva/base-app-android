package com.example.greencode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

    fun changePoints(v:View){
        val intent = Intent(this, Cupom::class.java)
        startActivity(intent)
        finish()
    }
}
