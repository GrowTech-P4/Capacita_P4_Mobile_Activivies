package com.br.capacita.Model

import com.google.gson.annotations.SerializedName

data class Login (
    @SerializedName("usuarioPCD")
    var usuarioPCD:UsuarioPCD,

    var token:String)