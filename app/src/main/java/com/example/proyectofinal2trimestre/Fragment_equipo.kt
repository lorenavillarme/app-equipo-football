package com.example.proyectofinal2trimestre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal2trimestre.databinding.FragmentEquipoBinding

class Fragment_equipo : Fragment() {

    private lateinit var binding: FragmentEquipoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentEquipoBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jugadores = mutableListOf(
        Jugador("David Clua Pumar", "portero", "28 años (07/01/1995)", "Vigo", "1.99m", "80kg", "Burgos CF", "" ,"Clua", "PORTERO", 1, "escuelaestech", R.drawable.j1),
        Jugador("Jany Lacroux", "lateral derecho", "27 años (26/02/1996)", "Bree (Bélgica)", "1.82m", "87kg", "Genk Sub'19", "Lateral derecho que también se desenvuelve bien como central. Internacional en categorías inferiores con Bélgica", "Lacroux", "LATERAL DERECHO", 2, "",  R.drawable.j2 ),
        Jugador("Ánge Ginés Alcalá", "lateral izquierdo", "28 años (19/06/1994)", "Peralada (Girona)", "1.73m", "76kg", "Girona FC", "Ha disputado más de 100 partidos en segunda", "Ginés", "LATERAL IZQUIERDO",3, "escuelaestech", R.drawable.j3),
        Jugador("Raúl Guraya Gómez", "defensa central", "34 años (14/05/1988)", "Madrid", "1.83m", "83kg", "Granada B", "Defensa central con gran experiencia en la categoría", "Guraya", "DEFENSA CENTRAL", 4, "", R.drawable.j4),
        Jugador("Alba Monjonell Vila", "defensa central", "38 años (06/06/1984)", "Villar del Arzobispo (Valencia)", "1.85m", "79kg", "Guadalajara", "Trayectoria: Valencia C - Valencia B - Barcelona B -- Gimnástic Tarragona -C.D. Guadalajara", "Monjonell", "DEFENSA CENTRAL", 5, "", R.drawable.j5),
        Jugador("Enzo Meneghello Peláez", "media punta", "33 años (23/03/1989)", "Santander", "1.84m", "94kg", "Racing Santander B", "Centrocampista ofensivo con buena zurda", "Mene", "MEDIAPUNTA", 6, "escuelaestech",  R.drawable.j6),
        Jugador("Manuel Cimbrón Ortiz", "mediocentro", "38 años (11/12/1984)", "Albacete", "1.77m", "103kg", "Valencia Mestalla", "Mediocentro de gran clase y muy técnico, que ayuda a sacar el balón jugado desde atrás", "Cimbrón", "MEDIOCENTRO", 7, "",  R.drawable.j7),
        Jugador("Abdoulaye Akeda Opono", "INinhterior derecho", "30 años (04/07/1992)", "Camerún", "1.75m", "76kg", "Almería B", "Jugador muy rápido y de desborde. Suele irse de sus rivales por velocidad", "Akeda", "INTERIOR DERECHO", 8, "",  R.drawable.j8),
        Jugador("Sergio Guillamas Urquijo", "interiior izquierdo", "31 años (16/01/1992)", "Vitoria-Gazteiz", "1.89m", "86kg", "Mallorca B", "A pesar de su altura, posee gran velocidad y regate en carrera. Jugador muy habilidoso, también útil en el juego aéreo.", "Guillamas", "INTERIOR IZQUIERDO", 9, "escuelaestech",  R.drawable.j9),
        Jugador("Víctor Pozo López", "delantero", "30 años (14/11/1992), ", "Córdoba", "1.83m", "83kg", "Córdoba CF", "Delantero con gran olfato de gol, la pasada temporada marcó 20 goles en la categoría de plata.","Pozo", "DELANTERO", 10, "", R.drawable.j10),
        Jugador("Arístides Martínez López", "segundo delantero", "37 años (24/10/1985)", "Granada", "1.76m", "68kg", "CF Motril", "Delantero habilidoso y de gran técnica. Bueno en el último pase.", "Ari", "SEGUNDO DELANTERO", 11, "", R.drawable.j11),
        Jugador("José Sierra Urquijo", "entrenador", "56 años (24/19/1965)", "Las Palmas (Gran Canaria)", "1.81m", "79kg", "CD Mensajero", "-Como jugador: Málaga (88-92), Marbella (92-93), Mérida (93-94), Espanyol (94-97), Mérida (97-99), Las Palmas (99-05)" +
                "-Como entrenador: 2º entrenador Algeciras (05-06), Mérida (06-07), Ojeador Numancia (07-08), Los Barrios (08-11), Vecindario (11-15)", "José Sierra", "ENTRENADOR", 12, "", R.drawable.player),
        )

        val recyclerView = binding.recyclerview

        val glm = GridLayoutManager(requireContext()
            , 2, RecyclerView.VERTICAL, false)

        recyclerView.layoutManager = glm
        val adapter = MyAdapter()
        binding.recyclerview.adapter = adapter
        adapter.update(jugadores)



    }
}