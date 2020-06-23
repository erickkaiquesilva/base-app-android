package com.example.greencode

import feign.Headers
import feign.RequestLine

interface EmailRequests {

   @Headers("Content-Type: application/json")
   @RequestLine("POST /email/cupon")
   fun enviarNovoCupon(usuario:Usuario) : String
}