package com.example.greencode

import com.example.greencode.Usuario
import feign.Param
import feign.RequestLine

interface UsuarioRequests {

    @RequestLine("GET /login/{email}/{senha}")
    fun login(@Param("email") email:String, @Param("senha") senha:String) : Usuario

}