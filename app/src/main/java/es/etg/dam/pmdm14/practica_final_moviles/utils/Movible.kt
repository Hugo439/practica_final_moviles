package es.etg.dam.pmdm14.practica_final_moviles.utils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

interface Movible {

    // Función para cambiar de actividad
    fun cambiarActividad(actual: AppCompatActivity, destino: Class<out AppCompatActivity>) {
        val intent = Intent(actual, destino)
        actual.startActivity(intent)
    }
    fun cambiarActividad(actual: AppCompatActivity, destino: Class<out AppCompatActivity>, clave: String, valor: String) {
        val intent = Intent(actual, destino).apply {
            putExtra(clave, valor)
        }
        actual.startActivity(intent)
    }

}