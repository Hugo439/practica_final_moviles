package es.etg.dam.pmdm14.practica_final_moviles.ui.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import es.etg.dam.pmdm14.gym.R
import es.etg.dam.pmdm14.gym.databinding.ActivityPrincipalBinding
import es.etg.dam.pmdm14.practica_final_moviles.utils.Movible

class PrincipalActivity : AppCompatActivity(), Movible {

    private lateinit var binding: ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializamos View Binding
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuramos el toolbar
        binding.toolbar.title = getString(R.string.app_name)
        setSupportActionBar(binding.toolbar)

        /*
        // Obtenemos el nombre del usuario desde el intent
        val userName = intent.getStringExtra("user_name")

        // Mostramos un mensaje de bienvenida
        val text = "Bienvenido $userName !!"
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()*/

        // Configuramos el botón para cambiar de actividad
        binding.btnPlanificacion.setOnClickListener {
            cambiarActividad(this, PlanningActivity::class.java)
        }
    }

    // Agregamos el menú al toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal_activity, menu)
        return true
    }

    // Manejar clics en los botones del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.btnSettings -> {
                Toast.makeText(this, R.string.msg_click_settings, Toast.LENGTH_LONG).show()
                true
            }

            R.id.btnExit -> {
                cambiarActividad(this, MainActivity::class.java)
                true
            }

            R.id.btnProfile -> {
                Toast.makeText(this, R.string.msg_click_profile, Toast.LENGTH_LONG).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
