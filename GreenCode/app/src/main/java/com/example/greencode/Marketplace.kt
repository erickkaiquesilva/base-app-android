package com.example.greencode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback

class Marketplace : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marketplace)
        createFragment()
    }

    fun createFragment() {
        val transaction_highlight = supportFragmentManager.beginTransaction()
        val transaction_most_searched = supportFragmentManager.beginTransaction()
        var i = 0
        while (i < 5) {
            transaction_highlight.add(R.id.highlights_list, Highlight())
            transaction_most_searched.add(R.id.most_searched_list, MostSearched())
            i++
        }
        transaction_highlight.commit()
        transaction_most_searched.commit()
    }

    fun backToHome(v:View){
        onBackPressed()
    }

}