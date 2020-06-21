package com.example.greencode

import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder

object ClienteUsuarioApi {

    fun criar(): UsuarioRequests {
        return Feign.builder()
            .decoder(GsonDecoder()) // classe responsável por criar os JSON nas requisições
            .encoder(GsonEncoder()) // classe responsável por converter JSON das respostas
            .target(UsuarioRequests::class.java, "https://jsonplaceholder.typicode.com")
    }
}