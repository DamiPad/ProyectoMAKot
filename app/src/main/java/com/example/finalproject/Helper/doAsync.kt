package com.example.finalproject.Helper

import android.os.AsyncTask

class doAsync(val handler: ()->Unit):AsyncTask<Void,Void,Void>() { //metodo que va a recibir
    override fun doInBackground(vararg params: Void?): Void? {

        handler()//tipo metodo

        return null
    }
}