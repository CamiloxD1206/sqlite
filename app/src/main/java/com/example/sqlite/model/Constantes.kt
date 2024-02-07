package com.example.sqlite.model

class Constantes {
    companion object {
        const val NOM_BD = "BdAdso"
        const val VERSION_BD = 7

        const val TABLA = "CREATE TABLE ciudad(cod int, nombre text, codedep int)"
        const val DATOS ="CREATE TABLE datos (codusu int, nombreusu text, apellidousu text, telefonousu int, direccionusu text)"
    }
}