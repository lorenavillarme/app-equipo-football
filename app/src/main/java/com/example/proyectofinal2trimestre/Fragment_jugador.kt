package com.example.proyectofinal2trimestre

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.fragment.app.Fragment

import com.example.proyectofinal2trimestre.databinding.FragmentJugadorBinding


class Fragment_jugador : Fragment() {

    private lateinit var binding: FragmentJugadorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentJugadorBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        arguments?.let { bundle ->
            val jugador = if (Build.VERSION.SDK_INT >=
                    Build.VERSION_CODES.TIRAMISU){
                bundle.getParcelable("jugador", Jugador::class.java)
            } else{
                bundle.getParcelable("jugador")
            }
            if (jugador != null){
                binding.tvApodo.text = jugador.apodo
                binding.tvNum.text = jugador.num.toString()
                binding.tvNombreJugador.text = jugador.nombre
                binding.tvPuestoJugador.text = jugador.puesto
                binding.tvEdadJugador.text = jugador.edad
                binding.tvLugarJugador.text = jugador.lugar_de_nacimiento
                binding.tvAlturaJugador.text = jugador.altura
                binding.tvPesoJugador.text = jugador.peso
                binding.tvProcedenciaJugador.text = jugador.procedencia
                binding.tvMasInfoJugador.text = jugador.mas_informacion
                val jugador_imagen = BitmapFactory.decodeResource(resources, jugador.imagen)
                binding.imgJugador.setImageBitmap(jugador_imagen)

                //función twitter
                if (jugador.twitter.isNotEmpty()){
                    binding.twitterIcon.visibility = View.VISIBLE
                }else{
                    binding.twitterIcon.visibility = View.GONE
                }

                (requireActivity() as MainActivity)
            }
        }

    }
}