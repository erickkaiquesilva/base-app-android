package com.example.greencode

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_highlight.*

class MostSearched : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_most_searched, container, false)
        view.setOnClickListener { view ->
            val intent = Intent(activity, Product::class.java)
            val product_obs = getText(R.string.product_obs)
            intent.putExtra("product_name", product_name.text.toString())
            intent.putExtra("product_valor", product_valor.text.toString())
            intent.putExtra("product_image", R.drawable.movies)
            intent.putExtra("product_obs", product_obs)
            intent.putExtra("usuarioLogado", activity?.intent?.getSerializableExtra("usuarioLogado"))
            startActivity(intent)
        }
        // Inflate the layout for this fragment
        return view
    }
}