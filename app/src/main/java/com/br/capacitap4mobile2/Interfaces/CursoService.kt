package com.br.capacitap4mobile2.Interfaces

import com.br.capacitap4mobile2.Model.Curso
import retrofit2.Call
import retrofit2.http.GET

interface CursoService {
    @GET("carrossel")
    fun getCurso(): Call<List<Curso>>
}