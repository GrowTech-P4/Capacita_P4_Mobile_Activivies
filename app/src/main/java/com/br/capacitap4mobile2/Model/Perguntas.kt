package com.br.capacitap4mobile2.Model

import com.google.gson.annotations.SerializedName

data class Perguntas(

    @SerializedName("_id")
    val _id: String,
    @SerializedName("descricao")
    val descricao: String,
    @SerializedName("titulo")
    val titulo: String,
    @SerializedName("data")
    val data: String,
    @SerializedName("nomeUsuario")
    val nomeUsuario: String,
    @SerializedName("respostas")
    val respostas: MutableList<Respostas>? = mutableListOf<Respostas>()
)