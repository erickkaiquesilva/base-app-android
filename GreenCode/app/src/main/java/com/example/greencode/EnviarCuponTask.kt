package com.example.greencode

import android.os.AsyncTask
import feign.FeignException

class EnviarCuponTask : AsyncTask<Usuario, Void, String>() {

    override fun doInBackground(vararg params: Usuario?):String? {
        try {
            return EmailApi.criar().enviarNovoCupon(params[0]!!)
        }catch (e: FeignException){
            return e.toString()
        }

    }

}