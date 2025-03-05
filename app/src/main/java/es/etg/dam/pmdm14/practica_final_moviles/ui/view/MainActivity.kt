package es.etg.dam.pmdm14.practica_final_moviles.ui.view

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import es.etg.dam.pmdm14.gym.databinding.ActivityMainBinding
import es.etg.dam.pmdm14.practica_final_moviles.utils.Movible

class MainActivity : AppCompatActivity(), Movible {

    companion object {
        const val READ_CONTACTS_REQUEST_CODE = 0
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inicializamos View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkReadContactsPermission()

        // Configuramos el listener para el botón "Login"
        binding.btnLoginMain.setOnClickListener {
            cambiarActividad(this, LoginActivity::class.java)
        }

        // Configuramos el listener para el botón "Register"
        binding.btnRegisterMain.setOnClickListener {
            cambiarActividad(this, RegisterActivity::class.java)
        }
    }

    //Comprueba si tiene permisos
    private fun checkReadContactsPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED) {
            //El permiso de acceso a los contactos no está aceptado, se pide
            requestReadConctactsPermission()
        } else {
            //El permiso está aceptado
            //aquí añadiríamos la lógica sobre los contactos
            Toast.makeText(this,"Acceso a la funcionalidad", Toast.LENGTH_SHORT).show()
        }
    }

    //Solicita el permiso
    private fun requestReadConctactsPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.CAMERA)) {
            //El usuario ya ha rechazado el permiso anteriormente, debemos indicarle que vaya a ajustes.
            Toast.makeText(this,"Conceda permisos en ajustes", Toast.LENGTH_SHORT).show()
        } else {
            //El usuario nunca ha aceptado ni rechazado, así que le solicitamos que acepte el permiso.
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.READ_CONTACTS),
                READ_CONTACTS_REQUEST_CODE
            )
        }
    }

    //Este método escucha la respuesta del usuario ante una solicitud de permisos
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            READ_CONTACTS_REQUEST_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    //El usuario ha aceptado el permiso, ya no hay que volver a solicitarlo, podemos lanzar la funcionalidad desde aquí.
                    Toast.makeText(this,"Acceso a la funcionalidad una vez aceptado el permiso", Toast.LENGTH_SHORT).show()
                } else {
                    //El usuario ha rechazado el permiso
                    Toast.makeText(this,"Conceda permisos en ajustes", Toast.LENGTH_SHORT).show()
                }
                return
            }
            else -> {
                // Para aquellos permisos no controlados
            }
        }
    }
}