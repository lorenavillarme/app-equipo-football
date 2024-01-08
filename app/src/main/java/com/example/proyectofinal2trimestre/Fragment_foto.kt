package com.example.proyectofinal2trimestre

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyectofinal2trimestre.databinding.FragmentFotoBinding


class Fragment_foto : Fragment() {

    private lateinit var binding: FragmentFotoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFotoBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { bundle ->
            val galeria = if (Build.VERSION.SDK_INT >=
                Build.VERSION_CODES.TIRAMISU
            ) {
                bundle.getParcelable("galeria", Galeria::class.java)
            } else {
                bundle.getParcelable("galeria")
            }

            if (galeria != null) {


             val foto = BitmapFactory.decodeResource(resources, galeria.foto)
              binding.imgIndividual.setImageBitmap(foto)
            }



            (requireActivity() as MainActivity)

        }
    }
}