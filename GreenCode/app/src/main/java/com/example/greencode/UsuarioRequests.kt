package com.example.greencode

import feign.Headers
import feign.Param
import feign.RequestLine

interface UsuarioRequests {

    @Headers("Content-Type: application/json")
    @RequestLine("POST /login")
    fun login(usuario: Usuario) : Usuario

    @Headers("Content-Type: application/json")
    @RequestLine("POST /signup")
    fun cadastrarUsuario(novoUsuario: Usuario) : Usuario

    @Headers("Content-Type: application/json")
    @RequestLine("POST /usuario/atualizarPontos/{pontos}")
    fun atualizarPontos( @Param("pontos") pontos: Int, usuario: Usuario) : Boolean

}