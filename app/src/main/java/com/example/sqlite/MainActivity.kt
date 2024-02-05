package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqlite.databinding.ActivityMainBinding
import com.example.sqlite.model.ManagerBd

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            val manager = ManagerBd(this)
            val resul = manager.insertData()
            Toast.makeText(this, "Base de Datos Creada"+resul, Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Error al insertar datos: ${e.message}", Toast.LENGTH_SHORT).show()
        }

    }
}