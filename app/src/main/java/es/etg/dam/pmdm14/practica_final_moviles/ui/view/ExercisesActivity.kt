package es.etg.dam.pmdm14.practica_final_moviles.ui.view

import android.os.Bundle
import android.util.Log
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

    private val viewModel: ExerciseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            binding = ActivityExercisesBinding.inflate(layoutInflater)
            setContentView(binding.root)
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error en el binding", Toast.LENGTH_LONG).show()
        }

        binding.btnInsert.setOnClickListener {
            insertExercise()
        }
        binding.btnCancel.setOnClickListener {
            cambiarActividad(this, PlanningActivity::class.java)
        }

    }

    private fun insertExercise() {
        val nameExercise = binding.editTxtNameExercise?.text?.toString() ?: ""
        val repetitions = binding.editRepetitions?.text?.toString()?.toIntOrNull() ?: 0
        val weightLifted = binding.editTxtweight?.text?.toString()?.toIntOrNull() ?: 0

        Log.d("ExercisesActivity", "Nombre: $nameExercise, Reps: $repetitions, Peso: $weightLifted")

        if (nameExercise.isNotEmpty() && repetitions > 0 && weightLifted > 0) {
            val exercise = Exercise(nameExercise, repetitions, weightLifted)
            lifecycleScope.launch {
                viewModel.addExercise(exercise)
                Toast.makeText(this@ExercisesActivity, "Ejercicio agregado", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos correctamente.", Toast.LENGTH_SHORT).show()
        }
    }

}

