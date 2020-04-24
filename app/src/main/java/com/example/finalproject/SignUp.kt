package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.Helper.doAsync
import com.example.finalproject.database.User
import com.example.finalproject.database.UserDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.*

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        // Insertamos el usuario a la base de datos
        btnCrearcuenta_m.setOnClickListener{
            val userName = edtNombre.text.toString()
            val phoneUser = edtTelefono.text.toString()
            val emailUser = edtCorreo1.text.toString()
            val passUser = edtContrasena.text.toString()
            val objUser = User(userName = userName,phoneUser = phoneUser, userEmail =  emailUser, userPass = passUser,userUpdateAt = Date())
            doAsync{
                UserDatabase.getInstance(this)!!.userDao().insertUser(objUser)
                //finish()
            }.execute()
            Toast.makeText(this,"Se registró el usuario", Toast.LENGTH_LONG).show()
        }



        btnIniciarSesion_sup.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }




    }
}

