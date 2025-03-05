package es.etg.dam.pmdm14.practica_final_moviles.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import es.etg.dam.pmdm14.practica_final_moviles.data.database.entities.ExerciseEntity

@Dao
interface ExerciseDao {
//Hay que poner el nombre de la tabla
    @Query ("SELECT * FROM ejercicios")
    suspend fun getAll(): List<ExerciseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ejercicio: ExerciseEntity)

    @Delete
    suspend fun delete(ejercicio: ExerciseEntity)

    @Query("SELECT * FROM ejercicios WHERE id = :id")
    suspend fun getById(id: Int): ExerciseEntity?

}