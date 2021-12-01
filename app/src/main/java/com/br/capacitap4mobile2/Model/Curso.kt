package com.br.capacita.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Curso(
    val nome: String,
    val descricao: String,
    val cargaHoraria: String,
    val tipoDeficiencia: String,
    val duracao: String,
    val valor: String? = "R$ 0,00",
    val dataConclusao: String,
    val img_curso: String = ""/*,
    val perguntas: MutableList<Perguntas>? = mutableListOf<Perguntas>(),
    val usuarioPCD: MutableList<UsuarioPCD>? = mutableListOf<UsuarioPCD>()*/
): Parcelable
