package com.example.greencode

import android.os.AsyncTask

class CadastrarUsuarioTask : AsyncTask<Usuario, Void, Usuario>() {

    override fun doInBackground(vararg params: Usuario?): Usuario {
        return ClienteUsuarioApi.criar().cadastrarUsuario(params[0]!!)
    }

}