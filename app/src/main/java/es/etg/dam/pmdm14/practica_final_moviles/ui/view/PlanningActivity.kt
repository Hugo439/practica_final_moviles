package es.etg.dam.pmdm14.practica_final_moviles.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import es.etg.dam.pmdm14.gym.R
import es.etg.dam.pmdm14.gym.databinding.ActivityPlanningBinding
import es.etg.dam.pmdm14.practica_final_moviles.utils.Movible

class PlanningActivity : AppCompatActivity(), Movible {

    private lateinit var binding: ActivityPlanningBinding

    private var tornoAbierto = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPlanningBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val mensaje = "No implementado!!"
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(this, mensaje,duration)


        binding.btmSelecEjer.setOnClickListener{
            toast.show()
        }
        binding.btnExit.setOnClickListener{
            cambiarActividad(this, PrincipalActivity::class.java)
        }

    }

    fun abrirTorno(view: View){

        supportFragmentManager.commit {
            setReorderingAllowed(true)

            binding.fragmentContainerView.visibility = View.VISIBLE
            binding.fragmentContainerViewCalendario.visibility = View.INVISIBLE

            binding.btnClose.visibility = View.VISIBLE
            binding.btnTorno.visibility = View.INVISIBLE
        }
    }
    fun cerrarTorno(view: View){

        supportFragmentManager.commit {
            setReorderingAllowed(true)

            binding.fragmentContainerViewCalendario.visibility = View.VISIBLE
            binding.fragmentContainerView.visibility = View.INVISIBLE

            binding.btnClose.visibility = View.INVISIBLE
            binding.btnTorno.visibility = View.VISIBLE
        }
    }
}
