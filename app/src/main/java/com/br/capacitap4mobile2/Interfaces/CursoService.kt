package com.br.capacita.Interfaces

import com.br.capacita.Model.Curso
import retrofit2.Call
import retrofit2.http.GET

interface CursoService {
    @GET("carrossel")
    fun getCurso(): Call<List<Curso>>
}