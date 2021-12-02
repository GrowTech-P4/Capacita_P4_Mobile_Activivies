package com.br.capacita.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class UsuarioPCD(
    @SerializedName("_id")
    var _id: String?,
    @SerializedName("nome")
    var nome: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("senha")
    var senha: String,
    @SerializedName("data_nascimento")
    var dataNascimento: String,
    @SerializedName("telefone")
    var telefone: String,
    @SerializedName("cpf")
    var cpf: String,
    @SerializedName("endereco")
    var endereco: String,
    @SerializedName("numero")
    var numero: String,
    @SerializedName("cep")
    var cep: String,
    @SerializedName("link_foto")
    var link_foto: String? = "",
    @SerializedName("bairro")
    var bairro: String,
   @SerializedName("tipoDeficiencia_ID")
    var tipoDeficiencia_ID: MutableList<TipoDeficiencia>,

    var token: String? = ""


)