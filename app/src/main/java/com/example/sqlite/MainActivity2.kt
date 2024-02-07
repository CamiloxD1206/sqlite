package com.example.sqlite

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sqlite.databinding.ActivityMain2Binding
import com.example.sqlite.model.ManagerBd

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var managerBd:ManagerBd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        managerBd = ManagerBd(this)

        binding.btnsqldos.setOnClickListener {
            val nombre = binding.editTextnombre.text.toString()
            val apellido = binding.editTextapellido.text.toString()
            val telefono = binding.editTexttelefono.text.toString()
            val direccion = binding.editTextdireccion.text.toString()
            val cod = binding.editTextcod.text.toString()

            if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || cod.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val resultado = managerBd.insertDataUser(cod, nombre, apellido, telefono, direccion)
                if (resultado != -1L) {
                    Toast.makeText(this, "Datos guardados correctamente $resultado", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MapsActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Error al guardar los datos", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }



}
