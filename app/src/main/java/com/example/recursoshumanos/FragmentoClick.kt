package com.example.recursoshumanos

//coisas que precisam ser passadas de fragmento para activity, e lá para outro fragmento
interface FragmentoClick {
    fun clickFragmento(nome: String, hora: Int, valor: Double)
}