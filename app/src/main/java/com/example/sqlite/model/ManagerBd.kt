package com.example.sqlite.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class ManagerBd(val context: Context) {
    lateinit var bd: SQLiteDatabase
    val bdHelper = BdHelper(context)

    fun openBdWr() {
        bd = bdHelper.writableDatabase
    }

    fun openBdRd() {
        bd = bdHelper.readableDatabase
    }

    fun insertData(ciudad: String, codigo: String): Long {
        openBdWr()
        val contenedor = ContentValues()
        contenedor.put("cod", codigo.toInt())
        contenedor.put("nombre", ciudad)

        val result = bd.insert("ciudad", null, contenedor)
        return result
    }


    fun insertDataUser(codusu:String,nombre: String,apellido:String,telefono:String,direccion:String): Long {
        openBdWr()
        val contenedor = ContentValues()
        contenedor.put("codusu", codusu.toInt())
        contenedor.put("nombreusu", nombre)
        contenedor.put("apellidousu", apellido)
        contenedor.put("telefonousu",telefono)
        contenedor.put("direccionusu",direccion)



        val resul = bd.insert("datos", null, contenedor)
        return resul
    }


}