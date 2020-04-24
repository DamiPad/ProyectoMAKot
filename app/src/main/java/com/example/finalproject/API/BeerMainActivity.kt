package com.example.finalproject.API

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apiadapter.Network
import com.example.finalproject.BeerActivity
import com.example.finalproject.R
import kotlinx.android.synthetic.main.beer_activity_main.*

class BeerMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.beer_activity_main)


        searchBtn.setOnClickListener {
            if (Network.hayRed(this)) {
                val intLista = Intent(this, BeerActivity::class.java)
                intLista.putExtra("RAZA", edtxtRaza.text.toString())
                startActivity(intLista)
            } else {
                Toast.makeText(this, "No hay red", Toast.LENGTH_LONG).show()
            }
        }
    }
}