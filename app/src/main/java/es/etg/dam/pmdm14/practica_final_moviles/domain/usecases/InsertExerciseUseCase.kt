package es.etg.dam.pmdm14.practica_final_moviles.domain.usecases

import es.etg.dam.pmdm14.practica_final_moviles.domain.model.Exercise
import es.etg.dam.pmdm14.practica_final_moviles.data.repository.ExerciseRepository
import javax.inject.Inject

class InsertPersonaUseCase @Inject constructor(
    private val repository: ExerciseRepository
) {

    suspend fun invoke(ejercicio: Exercise) {
        repository.insertar(ejercicio)
    }
}