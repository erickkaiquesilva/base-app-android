package com.example.greencode

import android.os.AsyncTask

class GetUsuarioTask : AsyncTask<String, Void, Usuario>(){

    override fun doInBackground(vararg params: String?): Usuario {
        return ClienteViaUsuario.criar().login(params[0]!!, params[1]!!)
    }
}