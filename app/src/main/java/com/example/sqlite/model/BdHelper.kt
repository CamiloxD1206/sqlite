package com.example.sqlite.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BdHelper(
    context: Context?
) : SQLiteOpenHelper(context, Constantes.NOM_BD, null, Constantes.VERSION_BD) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(Constantes.TABLA)
        db?.execSQL(Constantes.DATOS)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS ciudad")
        db?.execSQL("DROP TABLE IF EXISTS datos")
        onCreate(db)
    }
}