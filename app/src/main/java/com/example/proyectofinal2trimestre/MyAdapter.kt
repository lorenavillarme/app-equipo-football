package com.example.proyectofinal2trimestre

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal2trimestre.databinding.HolderJugadorBinding


class MyAdapter() : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

   private val dataList = ArrayList<Jugador>()

    inner class  MyViewHolder(val binding: HolderJugadorBinding) :
            RecyclerView.ViewHolder(binding.root){

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolderJugadorBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val jugador = dataList[position]


        with(holder.binding){
            holder.binding.imageView.setImageResource(jugador.imagen)
         holderJug.text = jugador.apodo
            holderPos.text = jugador.funcion_jugador

            //cambiar colores
            if (jugador.funcion_jugador == "PORTERO"){
                holderPos.setBackgroundColor(Color.MAGENTA)
                holderJug.setBackgroundColor(Color.MAGENTA)
            }
            if (jugador.funcion_jugador == "LATERAL DERECHO" || jugador.funcion_jugador == "LATERAL IZQUIERDO"
                || jugador.funcion_jugador == "DEFENSA CENTRAL"){
                holderPos.setBackgroundColor(Color.CYAN)
                holderJug.setBackgroundColor(Color.CYAN)
            }

            if (jugador.funcion_jugador == "MEDIAPUNTA" || jugador.funcion_jugador == "MEDIOCENTRO"
                || jugador.funcion_jugador == "INTERIOR DERECHO"  || jugador.funcion_jugador == "INTERIOR IZQUIERDO"){
                holderPos.setBackgroundColor(Color.GREEN)
                holderJug.setBackgroundColor(Color.GREEN)
            }

            if (jugador.funcion_jugador == "DELANTERO" || jugador.funcion_jugador == "SEGUNDO DELANTERO") {
                holderPos.setBackgroundColor(Color.RED)
                holderJug.setBackgroundColor(Color.RED)
            }

            if (jugador.funcion_jugador == "ENTRENADOR"){
                holderPos.setBackgroundColor(Color.BLACK)
                holderJug.setBackgroundColor(Color.BLACK)
            }

        }


        holder.itemView.setOnClickListener {
            val bundle = bundleOf(
                "jugador" to jugador
            )
            Navigation.findNavController(it).navigate(R.id.action_equipo_to_fragment_jugador, bundle)
        }


    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun add(item: Jugador){
        dataList.add(item)
        notifyItemInserted(dataList.size)
    }

    fun remove(){
        dataList.removeAt(dataList.size -1)
        notifyItemRemoved(dataList.size)
    }

    fun update(list: List<Jugador>){
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }
}