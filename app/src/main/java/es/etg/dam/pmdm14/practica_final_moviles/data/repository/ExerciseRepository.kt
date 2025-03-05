package es.etg.dam.pmdm14.practica_final_moviles.data.repository

import es.etg.dam.pmdm14.practica_final_moviles.data.database.dao.ExerciseDao
import es.etg.dam.pmdm14.practica_final_moviles.data.database.entities.ExerciseEntity
import es.etg.dam.pmdm14.practica_final_moviles.domain.model.Exercise
import javax.inject.Inject

class ExerciseRepository @Inject constructor(
    private val exerciseDao: ExerciseDao
) {
    suspend fun leerLista(): List<Exercise> {
        val exerciseEntities = exerciseDao.getAll()
        val listaExercises = mutableListOf<Exercise>()
        for (exerciseEntity in exerciseEntities) {
            listaExercises.add(
                Exercise(
                    exerciseEntity.nombreEjercicio,
                    exerciseEntity.repeticiones,
                    exerciseEntity.pesoLevantado
                )
            )
        }
        return listaExercises
    }

    suspend fun insertar(exercise: Exercise) {
        val exerciseEntity = ExerciseEntity(
            0, // ID autogenerado
            exercise.nombreEjercicio,
            exercise.repeticiones,
            exercise.pesoLevantado
        )
        exerciseDao.insert(exerciseEntity)
    }

    suspend fun obtenerEjercicioPorId(id: Int): Exercise? {
        val exerciseEntity = exerciseDao.getById(id)
        return if (exerciseEntity != null) {
            Exercise(
                exerciseEntity.nombreEjercicio,
                exerciseEntity.repeticiones,
                exerciseEntity.pesoLevantado
            )
        } else {
            null
        }
    }
}
