package com.example.greencode

import java.io.Serializable

data class Usuario (val id: Long? = null, val nome: String? = null, val sobrenome: String? = null,
                    val senha: String? = null, val email: String? = null, val pontos : Int? = null) : Serializable
