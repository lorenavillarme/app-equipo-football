package com.example.proyectofinal2trimestre

import android.R
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.example.proyectofinal2trimestre.databinding.FragmentContactoBinding


class Fragment_contacto : Fragment() {
    private lateinit var binding: FragmentContactoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactoBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botonEnviar.setOnClickListener {
            val nombre_user = binding.etNombre.text.toString()
            val email_user = binding.etEmail.text.toString()
            val tel_user = binding.etTel.text.toString()
            val mensaje_user = binding.etMensaje.text.toString()

            //comprobar email
            fun esCorrecto(email_user: String): Boolean {
                return Patterns.EMAIL_ADDRESS.matcher(email_user).matches()
            }

            //mostrar errores
            if (nombre_user.isEmpty()) {
                binding.etNombre.error = "Por favor, introduce tu nombre"
            } else if (email_user.isEmpty()) {
                binding.etEmail.error = "Por favor, introduce tu email"
            } else if (tel_user.isEmpty()) {
                binding.etTel.error = "Por favor, introduce tu teléfono"
            } else if (mensaje_user.isEmpty()) {
                binding.etMensaje.error = "Por favor, introduce tu mensaje"
            } else if (!binding.checkBoxAcepto.isChecked) {
                binding.checkBoxAcepto.error = "Por favor, acepta las condiciones"
            } else {

                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Mensaje del sistema")
                builder.setMessage("¿Quieres mandar el mensaje?")
                builder.setPositiveButton("Si", DialogInterface.OnClickListener { dialog, i ->

                    val nombre_dialog = nombre_user
                    val email_dialog = email_user
                    val tel_dialog = tel_user
                    val mensaje_dialog = mensaje_user

                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(
                        Intent.EXTRA_EMAIL,
                        arrayOf("info@escuelaestech.es", "secretaria@escuelaestech.es")
                    )
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Formulario")
                    intent.putExtra(
                        Intent.EXTRA_TEXT,
                        "Nombre: $nombre_dialog\nEmail: $email_dialog\nTeléfono: $tel_dialog\nMensaje: $mensaje_dialog"
                    )
                    startActivity(Intent.createChooser(intent, "Envío de correo electrónico"))

                    builder.setNegativeButton("No", null)
                    val dialog = builder.create().show()

                })
            }

            //spinner personas
            val persona = arrayOf("Socio", "Abonado", "Aficionado", "Simpatizante", "Otro")
            val personaAdapter =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_dropdown_item, persona)
            binding.spinner.adapter = personaAdapter


            //pasar email
            binding.botonEmail.setOnClickListener {
                val recipient = "info@escuelaestech.es"
                val subject = "Asunto"
                val message = "Mensaje"

                val intent = Intent(Intent.ACTION_SENDTO)
                intent.data = Uri.parse("mailto:$recipient")
                intent.putExtra(Intent.EXTRA_SUBJECT, subject)
                intent.putExtra(Intent.EXTRA_TEXT, message)
                startActivity(Intent.createChooser(intent, "Enviar"))
            }
        }

        //llamar
        binding.botonTel.setOnClickListener {
            val phoneNumber = "953 635 000"
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNumber")
            startActivity(intent)
        }

        //enviar whatsapp
        binding.botonWhatsapp.setOnClickListener {
            val number = "697 24 60 08"
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$number"))
            intent.setPackage("com.whatsapp")
            startActivity(intent)

        }

        //google maps
        binding.botonCalle.setOnClickListener {
            val address = "C/ San Joaquín, 12  23700 - Linares (Jaén)"

            val intentUri = Uri.parse("geo:0,0?q=$address")
            val intent = Intent(Intent.ACTION_VIEW, intentUri)
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }
    }
}


