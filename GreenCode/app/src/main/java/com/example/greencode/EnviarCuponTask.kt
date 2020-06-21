package com.example.greencode

import android.os.AsyncTask
import feign.FeignException

class EnviarCuponTask : AsyncTask<String, Void, String>() {

    override fun doInBackground(vararg params: String?):String? {

        try {
            return EmailApi.criar().enviarNovoCupon(params[0]!!)
        }catch (e: FeignException){
            return null
        }

    }

}