package com.br.capacitap4mobile2.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.br.capacita.Controller.CadastroUsuarioPCDController
import com.br.capacita.Model.TipoDeficiencia
import com.br.capacita.Model.UsuarioPCD
import com.br.capacitap4mobile2.R

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        lateinit var botao: Button
        lateinit var email: EditText
        lateinit var nome: EditText
        lateinit var senha: EditText
        lateinit var repetirSenha: EditText
        lateinit var cpf: EditText
        lateinit var dataNascimento: EditText
        lateinit var cep: EditText
        lateinit var telefone: EditText
        lateinit var endereco: EditText
        lateinit var numero: EditText
        lateinit var bairro: EditText
        lateinit var deficienciaVisual: CheckBox
        lateinit var deficienciaFisica: CheckBox
        lateinit var deficienciaMental: CheckBox
        lateinit var deficienciaMudez: CheckBox
        lateinit var deficienciaAuditiva: CheckBox

        botao = findViewById(R.id.buttonCadastrar)
        email = findViewById(R.id.editTextTextEmail)
        nome = findViewById(R.id.editTextTextCadastroNome)
        senha = findViewById(R.id.editTextTextSenha)
        repetirSenha = findViewById(R.id.editTextRepetirSenha)
        cpf = findViewById(R.id.editTextCpf)
        dataNascimento = findViewById(R.id.editTextNascimento)
        cep = findViewById(R.id.editTextCep)
        telefone = findViewById(R.id.editTextTelefone)
        endereco = findViewById(R.id.editTextLogradouro)
        numero = findViewById(R.id.editTextNumero)
        bairro = findViewById(R.id.editTextBairro)
        deficienciaFisica = findViewById(R.id.checkFisica)
        deficienciaVisual = findViewById(R.id.checkVisual)
        deficienciaMental = findViewById(R.id.checkMental)
        deficienciaMudez = findViewById(R.id.checkMudez)
        deficienciaAuditiva = findViewById(R.id.checkAuditiva)

        var tipoDeficiencias: MutableList<TipoDeficiencia> = mutableListOf<TipoDeficiencia>()
        var tipoDeficiencia = TipoDeficiencia("", "")

        botao.setOnClickListener {
            val email = email.text.toString().trim()
            val nome = nome.text.toString().trim()
            val senha = senha.text.toString().trim()
            val repetirSenha = repetirSenha.text.toString().trim()
            val cpf = cpf.text.toString().trim()
            val dataNascimento = dataNascimento.text.toString().trim()
            val cep = cep.text.toString().trim()
            val telefone = telefone.text.toString().trim()
            val endereco = endereco.text.toString().trim()
            val numero = numero.text.toString().trim()
            val bairro = bairro.text.toString().trim()
            if (deficienciaFisica.isChecked) {
                tipoDeficiencia._id = "61a57570a2f84d42c2cb27b1"
                tipoDeficiencias.add(tipoDeficiencia)
            }
            if (deficienciaAuditiva.isChecked) {
                tipoDeficiencia._id = "619ec98771c8a7ffa41182e9"
                tipoDeficiencias.add(tipoDeficiencia)
            }
            if (deficienciaMental.isChecked) {
                tipoDeficiencia._id = "61a57587a2f84d42c2cb27b4"
                tipoDeficiencias.add(tipoDeficiencia)
            }
            if (deficienciaMudez.isChecked) {
                tipoDeficiencia._id = "61a57591a2f84d42c2cb27b7"
                tipoDeficiencias.add(tipoDeficiencia)
            }
            if (deficienciaVisual.isChecked) {
                tipoDeficiencia._id = "619ec39508e77182a7d8b202"
                tipoDeficiencias.add(tipoDeficiencia)
            }
            val user = UsuarioPCD(
                null,
                nome,
                email,
                senha,
                dataNascimento,
                telefone,
                cpf,
                endereco,
                numero,
                cep,
                "",
                bairro,

                tipoDeficiencias,
                ""
            )
            CadastroUsuarioPCDController().cadastro(user)
            Toast.makeText(this, "Usuario cadastrado com sucesso", Toast.LENGTH_LONG).show()

            val home = Intent(this, MainActivity::class.java)
            startActivity(home)
        }


    }
}