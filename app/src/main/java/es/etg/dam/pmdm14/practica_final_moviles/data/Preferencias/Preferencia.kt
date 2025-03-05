package es.etg.dam.pmdm14.practica_final_moviles.data.Preferencias

interface Preferencia{

    fun guardar(nombre: String)

    fun leer(): String?
}