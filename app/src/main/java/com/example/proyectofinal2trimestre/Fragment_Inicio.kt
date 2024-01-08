package com.example.proyectofinal2trimestre

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyectofinal2trimestre.databinding.FragmentInicioBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class Fragment_Inicio : Fragment() {

    private lateinit var binding: FragmentInicioBinding
    private lateinit var sharedPreferences: SharedPreferences
    private var premio = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInicioBinding.inflate(inflater, container, false)
        //dar mensaje de bienvenida
        val sharedPreferences =
            requireActivity().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
        val user_ = sharedPreferences.getString("username", "")

        if (user_ == "") {
            binding.mensajeBienvenida.text = ""
        } else {
            binding.mensajeBienvenida.text = "bienvenido $user_"

        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    //premios con huevo de pascua
        var count = 0

        sharedPreferences = requireActivity().getSharedPreferences("MisPreferencias", MODE_PRIVATE)
        premio = sharedPreferences.getBoolean("premio", true)

        binding.escudo.setOnClickListener {
            count++
            if (count == 10 && premio) {
                premio_dialog()
                count = 0 // Reset the counter after showing the dialog
            }
        }
    }

    private fun premio_dialog() {
        premio = false
        val editor = sharedPreferences.edit()
        editor.putBoolean("premio", false)
        editor.apply()

        val lista_premios = arrayOf("PS4", "Nintendo Switch", "PC Gaming")
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("¡Escoge tu premio!")
            .setItems(lista_premios) { _, which ->
                val codeDialog = MaterialAlertDialogBuilder(requireContext())
                    .setMessage("¿Estás seguro de que quieres recoger el premio ${lista_premios[which]}?")
                    .setPositiveButton("Sí") { _, _ ->

                    }
                    .setNegativeButton("No") { _, _ -> }
                    .create()
                codeDialog.show()
            }
            .setOnCancelListener {
                //si el dialog se cancela se resetea
                premio = true
                val editor = sharedPreferences.edit()
                editor.putBoolean("premio", true)
                editor.apply()
            }
            .show()
    }


    }
