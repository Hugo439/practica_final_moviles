package es.etg.dam.pmdm14.gym.preferencias

interface Preferencia{

    fun guardar(nombre: String)

    fun leer(): String?
}