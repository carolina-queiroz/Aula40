package com.example.recursoshumanos

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.recursoshumanos.databinding.FragmentCadastroBinding

class CadastroFragment : Fragment() {
    private lateinit var binding: FragmentCadastroBinding
    private lateinit var interfaceClick: FragmentoClick
    private lateinit var nome: String
    private lateinit var horasTrabalhadas: String
    private lateinit var valorHora: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCadastroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            interfaceClick = context as MainActivity
        } catch (e: Exception) {
            Log.i("Erro", "Erro na inicialização da interface ${e.message}")
        }
    }

    private fun recuperarDados() {
        this.nome = binding.nomeESobrenome.text.toString()
        this.horasTrabalhadas = binding.horasTrabalhadas.text.toString()
        this.valorHora = binding.valorPorHora.text.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calcularSalario.setOnClickListener {
            recuperarDados()
            if (!verificarCampos()) {
                interfaceClick.clickFragmento(nome, horasTrabalhadas.toInt(), valorHora.toDouble())
                limparCampos()
            }
        }
    }

    fun verificarCampos(): Boolean {
        val context = context as MainActivity
        return if (nome.isEmpty() || horasTrabalhadas.isEmpty() || valorHora.isEmpty()) {
            Toast.makeText(context, "Todos os campos devem ser preenchidos", Toast.LENGTH_LONG).show()
            true
        } else {
            false
        }
    }

    private fun limparCampos() {
        binding.nomeESobrenome.text.clear()
        binding.horasTrabalhadas.text.clear()
        binding.valorPorHora.text.clear()
    }
}