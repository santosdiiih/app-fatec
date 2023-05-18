package com.example.app_fatec.model

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

class Chamado (
    @SerializedName("ChamadoId")
    var idChamado: Int = 0,
    @SerializedName("ChamadoId")
    var titulo: String = "",
    @SerializedName("ChamadoId")
    var dataAbertura: String = "02-12-2022",
    @SerializedName("ChamadoId")
    var dataFechamento: String = "",
    @SerializedName("ChamadoId")
    var dataAtualizacao: String = "02-12-2022",
    @SerializedName("ChamadoId")
    var descricao: String = "",
    @SerializedName("ChamadoId")
    var numeroChamado: String = "S982736",
    @SerializedName("ChamadoId")
    var imagemChamado: Bitmap? = null
    //var comentario: ArrayList<String>
        )