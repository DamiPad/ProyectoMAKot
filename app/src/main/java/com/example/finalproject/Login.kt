package com.example.finalproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.Helper.doAsync
import com.example.finalproject.database.User
import com.example.finalproject.database.UserDatabase
import kotlinx.android.synthetic.main.activity_main.*

class Login : AppCompatActivity() {
    private var user : User? = null
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //contexto es la actividad en la que estas trabajando

        btnIniciarSesion.setOnClickListener {

            /*
            *

            //comparo contral la tabla user de la bd
            doAsync{
                var user=  UserDatabase.getInstance(this)!!.userDao().validateuser(username1,userpass)
            }.execute()

            if (user != null){
                Toast.makeText(this, "Usuario valido", Toast.LENGTH_LONG).show()

            }else{
                password.setText("")
                edtCorreo1.setText("")
                Toast.makeText(this, "Usuario NO valido", Toast.LENGTH_LONG).show()

            }*/


        }
    }

}