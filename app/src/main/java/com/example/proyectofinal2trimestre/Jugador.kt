package com.example.proyectofinal2trimestre

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Jugador(
    val nombre: String,
    val puesto: String,
    val edad: String,
    val lugar_de_nacimiento: String,
    val altura: String,
    val peso: String,
    val procedencia: String,
    val mas_informacion: String,
    val apodo: String,
    val funcion_jugador: String,
    val num: Int,
    val twitter: String,
    val imagen: Int

) : Parcelable