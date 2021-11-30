package com.br.capacitap4mobile2.Interfaces

import com.br.capacitap4mobile2.Model.Instituicao
import retrofit2.Call
import retrofit2.http.GET

interface InstituicaoService {

    @GET("instituicao")
    fun getInstituicao(): Call<List<Instituicao>>
}