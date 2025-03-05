package es.etg.dam.pmdm14.practica_final_moviles.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ejercicios")
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var nombreEjercicio: String,
    var repeticiones: Int,
    var pesoLevantado: Int,
)
