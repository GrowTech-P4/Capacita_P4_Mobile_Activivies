package com.br.capacitap4mobile2.Model

import com.google.gson.annotations.SerializedName

data class Instituicao(

    @SerializedName("_id")
    val _id: String,
    @SerializedName("nome")
    val nome: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("senha")
    val senha: String,
    @SerializedName("telefone")
    val telefone: String,
    @SerializedName("cnpj")
    val cnpj: String,
    @SerializedName("endereco")
    val endereco: String,
    @SerializedName("numero")
    val numero: Int,
    @SerializedName("bairro")
    val bairro: String,
    @SerializedName("cep")
    val cep: String,
    @SerializedName("curso")
    val curso: MutableList<Curso>? = mutableListOf<Curso>()
)