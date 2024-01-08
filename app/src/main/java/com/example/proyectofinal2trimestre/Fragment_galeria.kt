package com.example.proyectofinal2trimestre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal2trimestre.databinding.FragmentGaleriaBinding

class Fragment_galeria : Fragment() {

    private lateinit var binding: FragmentGaleriaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGaleriaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lista_fotos = mutableListOf(
            Galeria(
                R.drawable.galeria_2
            ),

            Galeria(
                R.drawable.galeria_3
            ),

            Galeria(
                R.drawable.galeria_4
            ),
            Galeria(
                R.drawable.galeria_5
            ),
            Galeria(
                R.drawable.galeria_6
            ),
            Galeria(
                R.drawable.galeria_7
            ),
            Galeria(
                R.drawable.galeria_8
            ),
            Galeria(
                R.drawable.galeria_9
            ),
            Galeria(
                R.drawable.galeria_10
            ),
            Galeria(
                R.drawable.galeria_11
            ),
            Galeria(
                R.drawable.galeria_12
            ),
            Galeria(
                R.drawable.galeria_13
            ),
            Galeria(
                R.drawable.galeria_14
            ),
            Galeria(
                R.drawable.galeria_15
            ),
            Galeria(
                R.drawable.galeria_16
            ),
            Galeria(
                R.drawable.galeria_17
            ),
            Galeria(
                R.drawable.galeria_18
            ),
            Galeria(
                R.drawable.galeria_19
            ),

        )

        val recyclerView = binding.recyclerview

        val glm = GridLayoutManager(
            requireContext(), 3, RecyclerView.HORIZONTAL, false
        )

        recyclerView.layoutManager = glm
        val adapter = galeria_adapter()
        binding.recyclerview.adapter = adapter
        adapter.update(lista_fotos)




    }


}