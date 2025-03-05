package es.etg.dam.pmdm14.practica_final_moviles.domain.usecases

import es.etg.dam.pmdm14.practica_final_moviles.data.repository.ExerciseRepository
import es.etg.dam.pmdm14.practica_final_moviles.domain.model.Exercise
import javax.inject.Inject

class InsertExerciseUserCase @Inject constructor(
    private val repository: ExerciseRepository
) {

    suspend fun invoke(ejercicio: Exercise) {
        repository.insertar(ejercicio)
    }
}