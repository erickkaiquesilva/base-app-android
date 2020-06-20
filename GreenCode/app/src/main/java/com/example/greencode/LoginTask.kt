package com.example.greencode

import android.os.AsyncTask
import feign.FeignException

class LoginTask : AsyncTask<Usuario, Void, Usuario>() {

    override fun doInBackground(vararg params: Usuario?): Usuario? {

        try {
            return ClienteUsuarioApi.criar().login(params[0]!!)
        }catch (e: FeignException){
            return null
        }
    }

}