package com.example.greencode

import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder

object ClienteViaUsuario {

    fun criar(): UsuarioRequests {
        return Feign.builder()
            .decoder(GsonDecoder())
            .encoder(GsonEncoder())
            .target(UsuarioRequests::class.java, "http://greencode-backend-lb-355874270.us-east-1.elb.amazonaws.com")
    }

}