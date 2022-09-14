package com.example.recursoshumanos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recursoshumanos.databinding.ActivityMainBinding
import com.example.recursoshumanos.model.Funcionario

class MainActivity : AppCompatActivity(), FragmentoClick {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(binding.container.id, CadastroFragment())
            .commit()
    }

    //vai passar os componentes para a activity de resultado
    override fun clickFragmento(nome: String, hora: Int, valor: Double) {
        val funcionarioCadastrado = Funcionario(nome, hora, valor)

        val fragmentSalario = SalarioFragment ().apply {
            arguments = Bundle().apply {
                putParcelable("Funcionario", funcionarioCadastrado)
            }
        }
        supportFragmentManager
            .beginTransaction()
            .add(binding.container.id, fragmentSalario)
            .addToBackStack("Cadastro")
            .commit()
    }
}