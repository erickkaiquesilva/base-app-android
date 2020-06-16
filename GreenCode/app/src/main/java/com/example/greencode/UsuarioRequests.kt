package com.example.greencode

import feign.RequestLine

interface UsuarioRequests {

    @RequestLine("POST /login")
    fun login(usuario: Usuario) : Usuario


    @RequestLine("POST /signup")
    fun cadastrarUsuario(novoUsuario: Usuario) : Usuario


}