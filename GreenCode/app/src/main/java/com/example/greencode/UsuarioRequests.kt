package com.example.greencode

import feign.Param
import feign.RequestLine

interface UsuarioRequests {

    @RequestLine("POST /login")
    fun login(usuario: Usuario) : Usuario

    @RequestLine("POST /signup")
    fun cadastrarUsuario(novoUsuario: Usuario) : Usuario

    @RequestLine("POST /usuario/atualizarPontos/{pontos}")
    fun atualizarPontos( @Param("pontos") pontos: Int, usuario: Usuario) : Boolean

}