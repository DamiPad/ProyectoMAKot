package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.finalproject.API.BeerMainActivity
import com.example.finalproject.Helper.doAsync
import com.example.finalproject.database.UserDatabase
import kotlinx.android.synthetic.main.activity_main.*

import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    /*
        btnCrearCuenta.setOnClickListener {
            //Insert



            doAsync{
               UserDatabase.getInstance(this)!!.userDao().insertUser(objUser)// contexto se refiere a actividad o clase local
            }.execute()
            Toast.makeText(this,"Usuario insertado",Toast.LENGTH_LONG).show()

            //update

            doAsync{
                //linea para no tener el adapter
                // y este objeto cargarlo al formulario

                val objUserUp= UserDatabase.getInstance(this)!!.userDao().getUserById(1)// contexto se refiere a actividad o clase local
                UserDatabase.getInstance(this)!!.userDao().updateUser(objUserUp)
            }.execute()

        } */
        btnIniciarSesion.setOnClickListener {
            Toast.makeText(this,"Se intento iniciar sesion", Toast.LENGTH_LONG).show()

            var username1 = edtCorreo.text.toString()
            var userpass= password.text.toString()


            //comparo contral la tabla user de la bd
            doAsync{
                var user=  UserDatabase.getInstance(this)!!.userDao().validateuser(username1,userpass)
            }.execute()

            if (username1 != null){
                Toast.makeText(this, "Usuario valido", Toast.LENGTH_LONG).show()
               // val intent = Intent(this, BeerMainActivity::class.java)
                //startActivity(intent)

                val intent2 = Intent(this, MenuActivity::class.java)
                startActivity(intent2)


            }else{
                password.setText("")
                edtCorreo.setText("")
                Toast.makeText(this, "Usuario NO valido", Toast.LENGTH_LONG).show()

            }
            //val objUser = User(userName = "Eddieware",phoneUser = "4622494244", userEmail = "eddieware@gmail",userPass = "1234",userUpdateAt = Date())

        }


        btnCreatecount_log.setOnClickListener {
            //Toast.makeText(this,"Crear Cuenta", Toast.LENGTH_LONG).show()
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)

        }

    }



}



