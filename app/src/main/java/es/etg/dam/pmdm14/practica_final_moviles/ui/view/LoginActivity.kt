package es.etg.dam.pmdm14.practica_final_moviles.ui.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.etg.dam.pmdm14.gym.databinding.ActivityLoginBinding
import es.etg.dam.pmdm14.practica_final_moviles.data.Preferencias.PreferenciaUtil

import es.etg.dam.pmdm14.practica_final_moviles.utils.Movible

class LoginActivity : AppCompatActivity(), Movible {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inicializamos View Binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cambiamos el texto del EditText usando View Binding
        binding.editTxtUserName.setText(PreferenciaUtil(this).leer())

        // Asociamos listeners a los botones usando View Binding
        binding.btnLoginLogin.setOnClickListener {
            val userName = binding.editTxtUserName.text.toString()
            cambiarActividad(this, PrincipalActivity::class.java, "user_name", userName)
            PreferenciaUtil(this).guardar(userName)
        }

        binding.btnCancelLogin.setOnClickListener {
            cambiarActividad(this, MainActivity::class.java)
        }

        binding.txtAccount.setOnClickListener {
            cambiarActividad(this, RegisterActivity::class.java)
        }
    }
}