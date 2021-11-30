package com.br.capacitap4mobile2.Model

import com.google.gson.annotations.SerializedName

data class UsuarioPCD(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("nome")
    val nome: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("senha")
    val senha: String,
    @SerializedName("data_nascimento")
    val dataNascimento: String,
    @SerializedName("telefone")
    val telefone: String,
    @SerializedName("cpf")
    val cpf: String,
    @SerializedName("endereco")
    val endereco: String,
    @SerializedName("numero")
    val numero: Int,
    @SerializedName("cep")
    val cep: Int,
    @SerializedName("link_foto")
    val link_foto: String? = "",
    @SerializedName("bairro")
    val bairro: String,
    @SerializedName("tipoDeficiencia")
    val tipoDeficiencia: MutableList<TipoDeficiencia>

)