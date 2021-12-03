package com.br.capacita.Interfaces

import com.br.capacita.Model.Curso
import com.br.capacita.Model.UsuarioPCD
import retrofit2.Call
import retrofit2.http.*

interface CursoService {
    @GET("carrossel")
    fun getCurso(): Call<List<Curso>>


    @Headers("Content-Type:application/json; charset=UTF-8")
    @PUT("curso/{id}")
    fun inscCurso(

        @Header("authorization") token: String,
        @Path("id") id: String,
        /*@Body _idUsuario: String*/
    ): Call<Curso>
}