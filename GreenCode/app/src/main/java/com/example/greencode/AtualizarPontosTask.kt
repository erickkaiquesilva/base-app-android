package com.example.greencode

import android.os.AsyncTask
import feign.FeignException

class AtualizarPontosTask : AsyncTask<Usuario, Void, Boolean>() {

    override fun doInBackground(vararg params: Usuario?): Boolean? {

        try {
            return ClienteUsuarioApi.criar().atualizarPontos(params[0]?.pontos!!, params[0]!!)
        }catch (e: FeignException){
            return null
        }


    }

}