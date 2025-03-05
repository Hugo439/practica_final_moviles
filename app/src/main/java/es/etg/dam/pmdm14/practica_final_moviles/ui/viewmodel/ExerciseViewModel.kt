package es.etg.dam.pmdm14.practica_final_moviles.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.etg.dam.pmdm14.practica_final_moviles.domain.model.Exercise
import es.etg.dam.pmdm14.practica_final_moviles.domain.usecases.GetExerciseByIdUseCase
import es.etg.dam.pmdm14.practica_final_moviles.domain.usecases.InsertExerciseUserCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    private val getExerciseByIdUseCase: GetExerciseByIdUseCase,
    private val addExerciseUseCase: InsertExerciseUserCase
) : ViewModel() {

    private val _exercise = MutableLiveData<Exercise?>()
    val exercise: LiveData<Exercise?> get() = _exercise

    fun cargarEjercicio(id: Int) {
        viewModelScope.launch {
            _exercise.value = getExerciseByIdUseCase(id)
        }
    }

    fun addExercise(exercise: Exercise) {
        viewModelScope.launch {
            addExerciseUseCase.invoke(exercise)
        }
    }
}
