package com.example.recursoshumanos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recursoshumanos.databinding.FragmentSalarioBinding
import com.example.recursoshumanos.model.Funcionario

class SalarioFragment : Fragment() {
    private lateinit var binding: FragmentSalarioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSalarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val funcionarioCadastrado = arguments?.getParcelable<Funcionario>("Funcionario")

        if (funcionarioCadastrado != null){
            exibirDados(funcionarioCadastrado)
        }
    }

    private fun exibirDados(funcionario: Funcionario){
        binding.tvNome.text = funcionario.getNome()
        binding.tvHorasTrabalhadas.text = "Horas Trabalhadas: ${funcionario.getHorasTrabalhadas()}h"
        binding.tvValorHora.text = "Valor por hora: R$ ${funcionario.getValorHora()}"
        binding.tvValorSalario.text = "Salário a receber: R$ ${funcionario.getSalario()}"
    }
}