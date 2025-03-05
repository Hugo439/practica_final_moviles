package es.etg.dam.pmdm14.practica_final_moviles.data.Preferencias

import android.content.Context
import es.etg.dam.pmdm14.gym.preferencias.Preferencia

private const val PREFERENCIAS_USUARIO = "PreferenciasUsuario"

private const val NOMBRE_USUARIO = "nombreUsuario"

private const val VACIO = ""

class PreferenciaUtil(private val context: Context): Preferencia {

    override fun guardar(nombreUsuario: String) {
        val sharedPref = context.getSharedPreferences(PREFERENCIAS_USUARIO, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(NOMBRE_USUARIO, nombreUsuario)
        editor.apply()
    }

    override fun leer(): String? {
        val sharedPref = context.getSharedPreferences(PREFERENCIAS_USUARIO, Context.MODE_PRIVATE)
        return sharedPref.getString(NOMBRE_USUARIO, VACIO)
    }

}