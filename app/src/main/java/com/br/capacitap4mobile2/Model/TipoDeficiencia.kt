package com.br.capacitap4mobile2.Model

import com.google.gson.annotations.SerializedName

data class TipoDeficiencia(
    @SerializedName("_id")
    val _id: String?,
    @SerializedName("nome")
    val nome: String?
)