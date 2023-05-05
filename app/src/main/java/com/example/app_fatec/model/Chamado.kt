package com.example.app_fatec.model

import android.graphics.Bitmap
import java.util.*
import kotlin.collections.ArrayList

class Chamado (
    var idChamado: Int = 0,
    var titulo: String = "",
    var dataAbertura: String = "02-12-2022",
    var dataFechamento: String = "",
    var dataAtualizacao: String = "02-12-2022",
    var descricao: String = "",
    var numeroChamado: String = "S982736",
    var imagemChamado: Bitmap? = null
    //var comentario: ArrayList<String>
        )