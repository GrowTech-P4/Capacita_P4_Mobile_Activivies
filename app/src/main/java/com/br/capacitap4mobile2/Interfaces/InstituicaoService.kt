package com.br.capacita.Interfaces

import com.br.capacita.Model.Instituicao
import retrofit2.Call
import retrofit2.http.GET

interface InstituicaoService {

    @GET("instituicao")
    fun getInstituicao(): Call<List<Instituicao>>
}