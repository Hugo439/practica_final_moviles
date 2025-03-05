package es.etg.dam.pmdm14.practica_final_moviles.domain.usecases

import es.etg.dam.pmdm14.practica_final_moviles.data.repository.ExerciseRepository
import es.etg.dam.pmdm14.practica_final_moviles.domain.model.Exercise
import javax.inject.Inject

class GetExercisesUseCase @Inject constructor(
    private val repository: ExerciseRepository
) {
    suspend operator fun invoke() : List<Exercise> {
        val personas = repository.leerLista()
        return personas
    }
}
