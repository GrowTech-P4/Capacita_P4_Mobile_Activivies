package com.br.capacitap4mobile2.Connection

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// IP PARA PODER RODAR LOCALHOST DA API NO EMULADOR SEM DAR ERRO 10.0.2.2
const val URL_BASE = "http://10.0.2.2:3000/"

class RetrofitClient {
    companion object {
        fun <T> abrirConexao(interfaceApi: Class<T>): T {
            val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL_BASE)
                .build()
                .create(interfaceApi)

            return retrofitBuilder
        }

    }
}