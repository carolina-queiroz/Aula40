package com.example.recursoshumanos.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Funcionario(
    private var nome: String,
    private var horasTrabalhadas: Int,
    private var valorHora: Double
) : Parcelable {
    private var salario = horasTrabalhadas * valorHora

    fun getNome() = this.nome
    fun getHorasTrabalhadas() = this.horasTrabalhadas
    fun getValorHora() = this.valorHora
    fun getSalario() = this.salario
}