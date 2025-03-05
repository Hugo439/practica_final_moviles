package es.etg.dam.pmdm14.practica_final_moviles.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import es.etg.dam.pmdm14.practica_final_moviles.domain.model.Exercise
import es.etg.dam.pmdm14.practica_final_moviles.ui.viewmodel.ExerciseViewModel
import es.etg.dam.pmdm14.practica_final_moviles.utils.Movible
import dagger.hilt.android.AndroidEntryPoint
import es.etg.dam.pmdm14.gym.databinding.ActivityExercisesBinding
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ExercisesActivity : AppCompatActivity(), Movible {

    // Instancia del ViewBinding
    private lateinit var binding: ActivityExercisesBinding

    // Obtén el ViewModel correctamente
    private val viewModel: ExerciseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla el layout con el binding
        binding = ActivityExercisesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Puedes acceder a los elementos de la vista usando el binding
        binding.btnInsert.setOnClickListener {

            insertExercise()
        }
    }

    private fun insertExercise() {
        // Obtener los datos de los EditText
        val nameExercise = binding.editTxtNameExercise.text.toString()
        val repetitions = binding.editRepetitions.text.toString().toIntOrNull() ?: 0
        val weightLifted = binding.editTxtweight.text.toString().toIntOrNull() ?: 0

        // Validar los datos (puedes hacer más validaciones según sea necesario)
        if (nameExercise.isNotEmpty() && repetitions > 0 && weightLifted > 0) {
            val exercise = Exercise(nameExercise, repetitions, weightLifted)
            // Llamar al ViewModel para agregar el ejercicio
            lifecycleScope.launch {
                viewModel.addExercise(exercise)
                Toast.makeText(this@ExercisesActivity, "Ejercicio agregado", Toast.LENGTH_SHORT).show()
            }
        } else {
            // Mostrar mensaje si los datos son inválidos
            Toast.makeText(this, "Por favor, complete todos los campos correctamente.", Toast.LENGTH_SHORT).show()
        }
    }
}

