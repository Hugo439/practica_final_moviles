package es.etg.dam.pmdm14.practica_final_moviles.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import es.etg.dam.pmdm14.practica_final_moviles.data.database.dao.ExerciseDao
import es.etg.dam.pmdm14.practica_final_moviles.data.database.entities.ExerciseEntity

@Database(entities = [ExerciseEntity::class], version = 1)
abstract class ExcercisesDatabase: RoomDatabase() {

    abstract fun excerciseDao(): ExerciseDao
}