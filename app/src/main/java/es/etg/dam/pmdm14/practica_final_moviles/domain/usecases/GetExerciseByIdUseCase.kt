package es.etg.dam.pmdm14.practica_final_moviles.domain.usecases

import es.etg.dam.pmdm14.practica_final_moviles.data.repository.ExerciseRepository
import es.etg.dam.pmdm14.practica_final_moviles.domain.model.Exercise
import javax.inject.Inject

class GetExerciseByIdUseCase @Inject constructor(
    private val repository: ExerciseRepository
) {
    suspend operator fun invoke(id: Int): Exercise? {
        return repository.obtenerEjercicioPorId(id)
    }
}