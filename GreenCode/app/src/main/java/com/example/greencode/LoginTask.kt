package com.example.greencode

import android.os.AsyncTask

class LoginTask : AsyncTask<Usuario, Void, Usuario>() {

    override fun doInBackground(vararg params: Usuario?): Usuario {
        return ClienteUsuarioApi.criar().login(params[0]!!)
    }

}