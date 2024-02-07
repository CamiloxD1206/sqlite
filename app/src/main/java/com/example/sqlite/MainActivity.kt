package com.example.sqlite

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sqlite.databinding.ActivityMainBinding
import com.example.sqlite.model.ManagerBd

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var managerBd: ManagerBd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managerBd = ManagerBd(this)
        binding.btnsql.setOnClickListener {
            val ciudad = binding.textcod.text.toString()
            val codigo = binding.textciudad.text.toString()

            if (ciudad.isEmpty() || codigo.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val resultado = managerBd.insertData(ciudad, codigo)
                if (resultado != -1L) {
                    Toast.makeText(this, "Datos guardados correctamente $resultado", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}
