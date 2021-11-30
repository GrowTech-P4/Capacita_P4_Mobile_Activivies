package com.br.capacita.Interfaces

import com.br.capacita.Model.Login
import com.br.capacita.Model.UsuarioPCD
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginInterface {
    @POST("login")
    fun login(@Body user: UsuarioPCD): Call<Login>
}