package com.example.proyectofinal2trimestre

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.Navigation
import com.example.proyectofinal2trimestre.databinding.HolderGaleriaBinding


class galeria_adapter() : RecyclerView.Adapter<galeria_adapter.MyViewHolder>() {

    private val dataList = ArrayList<Galeria>()


    inner class  MyViewHolder(val binding: HolderGaleriaBinding) :
        RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolderGaleriaBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val galeria = dataList[position]

        with(holder.binding){
            holder.binding.imgGaleriaHolder.setImageResource(galeria.foto)
        }

        holder.itemView.setOnClickListener {
            val bundle = bundleOf(
                    "galeria" to galeria
            )
            Navigation.findNavController(it).navigate(R.id.action_fragment_galeria_to_fragment_foto, bundle)
        }

    }



    override fun getItemCount(): Int {
        return dataList.size

    }

    fun update(list: List<Galeria>){
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }

}