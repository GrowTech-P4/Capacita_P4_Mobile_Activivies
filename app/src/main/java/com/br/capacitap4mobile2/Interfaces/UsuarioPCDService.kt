package com.br.capacitap4mobile2.Interfaces

import com.br.capacitap4mobile2.Model.UsuarioPCD
import retrofit2.Call
import retrofit2.http.*

interface UsuarioPCDService {

    @GET("usuariopcd")
    fun list(): Call<List<UsuarioPCD>>

    @GET("usuariopcd/{_id}")
    fun getOne(@Path("_id") _id:String): Call<UsuarioPCD>

    @POST("usuariopcd")
    fun createUser(@Body user: UsuarioPCD
    ): Call<UsuarioPCD>

    @PUT("usuariopcd/{_id}")
    fun updateUser(@Body user:UsuarioPCD, @Path("_id") _id:String): Call<UsuarioPCD>

    @DELETE("usuariopcd/{_id}")
    fun deleteUser(@Path("_id") _id:String): Call<UsuarioPCD>
}