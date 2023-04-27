package com.example.app_fatec.model

import java.util.*

data class Usuario(
    var idSolicitante: Int = 0,
    var nome: String = "",
    var dataNascimento: String = "",
    var email: String = "",
    var senha: String = "",
    var funcao: String = "",
    var gestor: String = "",
    var contato: String = "",
    var status: Boolean
)