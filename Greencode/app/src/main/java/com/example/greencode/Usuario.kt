package com.example.greencode

import java.io.Serializable


data class Usuario(val id:Long, val nome:String, val sobrenome:String, val senha:String, val email:String,
val cpf:String, val pontos:Int, val admin:Boolean, val totalItens:Int) : Serializable