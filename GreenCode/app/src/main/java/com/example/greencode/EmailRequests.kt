package com.example.greencode

import feign.RequestLine

interface EmailRequests {

   @RequestLine("POST /email/cupon")
   fun enviarNovoCupon(email:String) : String
}