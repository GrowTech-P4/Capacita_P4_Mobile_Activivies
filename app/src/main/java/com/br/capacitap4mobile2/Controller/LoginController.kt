package com.br.capacita.Controller


import android.content.Context
import com.br.capacita.Interfaces.LoginInterface
import com.br.capacita.Model.Login
import com.br.capacita.Model.UsuarioPCD
import com.br.capacitap4mobile2.Connection.RetrofitClient
import com.br.capacitap4mobile2.Controller.SessionManager
import com.br.capacitap4mobile2.View.CursoDetalheActivity
import com.br.capacitap4mobile2.View.LoginActivity
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginController {
    fun login(user: UsuarioPCD, context: Context): UsuarioPCD {
        lateinit var message: String
        message = ""

        val sessionManager = SessionManager(context)
        val responseUsuario = RetrofitClient.abrirConexao(LoginInterface::class.java)
        responseUsuario.login(user).enqueue(object : Callback<Login> {
            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                val teste = response.body()
                if (teste == null) {
                    message = "Email ou senha Inválido, tente novamente"

                } else {
                    user.token = response.body()!!.token
                    user.nome = response.body()!!.usuarioPCD.nome
                    user.email = response.body()!!.usuarioPCD.email
                    user._id = response.body()!!.usuarioPCD._id
                    message = "Login efetuado com sucesso"
                    val gson = Gson()
                    val json = gson.toJson(user)
                    sessionManager.saveAuthToken(json)
                }
            }

            override fun onFailure(call: Call<Login>, t: Throwable) {
            }

        })

        return user
    }
}