package com.example.greencode

import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder

object EmailApi {

    fun criar(): EmailRequests {
        return Feign.builder()
            .decoder(GsonDecoder()) // classe responsável por criar os JSON nas requisições
            .encoder(GsonEncoder()) // classe responsável por converter JSON das respostas
            .target(EmailRequests::class.java, "https://jsonplaceholder.typicode.com")
    }

}