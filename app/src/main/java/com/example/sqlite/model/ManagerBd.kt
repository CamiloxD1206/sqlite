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

    fun insertData(): Long {
        openBdWr()
        val contenedor = ContentValues()
        contenedor.put("cod", 1)
        contenedor.put("nombre", "cartago")
        contenedor.put("codedep", 25)
        val result = bd.insert("ciudad", null, contenedor)
        return result
    }
}