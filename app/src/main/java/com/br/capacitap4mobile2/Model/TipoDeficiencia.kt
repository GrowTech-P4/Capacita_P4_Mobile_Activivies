package com.br.capacita.Model

import com.google.gson.annotations.SerializedName

data class TipoDeficiencia(
    @SerializedName("_id")
    var _id: String? = "",
    @SerializedName("nome")
    var nome: String?
)

