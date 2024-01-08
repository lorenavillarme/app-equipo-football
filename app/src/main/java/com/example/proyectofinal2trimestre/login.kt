package com.example.proyectofinal2trimestre

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectofinal2trimestre.databinding.LoginBinding


class login : AppCompatActivity() {

    //implementa binding
    private lateinit var binding: LoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*FLAG_ACTIVITY_CLEAR_TASK borra todas las actividades de la pila de tareas del usuario y
         crea una nueva instancia de MainActivity como actividad de inicio de la nueva tarea.
          Hay uno por cada startActivity */

        binding.botonlogin.setOnClickListener {
            val user_ = binding.usuario.text.toString()
            val password_ = binding.contrasenia.text.toString()

            // Obtener el objeto SharedPreferences
            val prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
            // Obtener el editor SharedPreferences para editar las preferencias
            val editor = prefs.edit()
            // Guardar el nombre de usuario en las preferencias si no es un invitado
            if (!user_.equals("invitado")) {
                editor.putString("username", user_)
            }
            // Aplicar los cambios
            editor.apply()


            //mostrar errores
            if (user_.isEmpty()) {
                binding.usuario.error = "Por favor, rellena el campo usuario"
            } else if (password_.isEmpty()) {
                binding.contrasenia.error = "Por favor, rellena el campo contraseña"

            } else {
                if (user_.equals("aficionado") && password_.equals("123456")) {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)

                } else if (user_.equals("jugador") && password_.equals("qwerasdf")) {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)

                } else if (user_.equals("directivo") && password_.equals("asdfasdf")) {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)

                } else {
                    Toast.makeText(
                        this,
                        "Ha ocurrido un error en el registro, por favor comprueba tu nombre de usuario y contraseña",
                        Toast.LENGTH_SHORT
                    ).show()
                }


            }


        }
        //entrar directamente
        binding.botoninvitados.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // Obtener el objeto SharedPreferences
        val prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
        // Obtener el nombre de usuario guardado en las preferencias
        val username = prefs.getString("username", "")
        // Establecer el texto del EditText con el nombre de usuario obtenido si no es un invitado
        if (!username.equals("invitado")) {
            binding.usuario.setText(username)
        }


    }
}