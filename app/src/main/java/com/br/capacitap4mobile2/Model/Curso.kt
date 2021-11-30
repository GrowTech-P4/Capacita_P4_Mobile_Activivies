package com.br.capacitap4mobile2.Model

data class Curso(
    val nome: String,
    val descricao: String,
    val cargaHoraria: String,
    val tipoDeficiencia: String,
    val duracao: String,
    val valor: String? = "R$ 0,00",
    val dataConclusao: String,
    val img_curso: String = "",
    val perguntas: MutableList<Perguntas>? = mutableListOf<Perguntas>(),
    val usuarioPCD: MutableList<UsuarioPCD>? = mutableListOf<UsuarioPCD>()
)