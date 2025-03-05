package es.etg.dam.pmdm14.practica_final_moviles.ui.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import es.etg.dam.pmdm14.gym.databinding.ActivityRegisterBinding
import es.etg.dam.pmdm14.practica_final_moviles.data.database.ExcercisesDatabase
import es.etg.dam.pmdm14.practica_final_moviles.utils.Movible

class RegisterActivity : AppCompatActivity(), Movible {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializamos View Binding
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Configuramos el listener para el botón "Cancelar"
        binding.btnCancelRegister.setOnClickListener {
            cambiarActividad(this, MainActivity::class.java)
        }

        // Configuramos el listener para el TextView "¿Ya tienes cuenta?"
        binding.txtHaveAccount.setOnClickListener {
            cambiarActividad(this, LoginActivity::class.java)
        }

        binding.btnNext.setOnClickListener {
            //guardar(it)
            cambiarActividad(this, PrincipalActivity::class.java)
        }
    }
    /*fun guardar(view: View){
        val nombreUsuario: String = binding.editTxtUserNameRegister.text.toString()
        val nombre: String = binding.editTxtName.text.toString()
        val apellidos: String = binding.editTxtSurname.text.toString()
        val email: String = binding.editTextEmail.text.toString()
        val password: String = binding.editTxtPasswordRegister.text.toString()
        val usuario = MachineEntity(0, nombreUsuario, nombre,apellidos,email,password);
        val UserDao = database.UserDao()

        //En el disppatcher IO es para entradas y salidas: bases de datos, ficheros, redes...
        CoroutineScope(Dispatchers.IO).launch {
            UserDao.insert(usuario)
        }
    }*/
}