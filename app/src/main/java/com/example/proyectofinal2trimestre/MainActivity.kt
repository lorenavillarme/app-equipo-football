package com.example.proyectofinal2trimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.proyectofinal2trimestre.databinding.ActivityMainBinding
import com.example.proyectofinal2trimestre.databinding.NavHeaderBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var headerBinding: NavHeaderBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        headerBinding = NavHeaderBinding.bind(binding.navView.getHeaderView(0))
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar2)

        // obtener la fecha actual
        val df =  SimpleDateFormat("dd/MM/yyyy")
        val fecha = df.format(Date())
        val currentDate = DateFormat.getDateInstance().format(Date())


        // mostrar la fecha en el textView
        headerBinding.fecha.text = fecha


        navController = findNavController(R.id.container_view)
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.home,
            R.id.equipo,
            R.id.galeria,
            R.id.contacto

        ), binding.drawer)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)



    }
//dialog para salir de la app
    override fun onBackPressed() {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("¿Salir?")
            builder.setMessage("¿Estás seguro de que quieres salir de la aplicación?")
            builder.setPositiveButton("Sí") { _, _ ->
                //si el usuario confirma que quiere salir, cerrar la aplicación
                finish()

            }
            builder.setNegativeButton("No", null)
            builder.show()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_logout, menu)
        return true
    }

//logout
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                AlertDialog.Builder(this)
                    .setTitle("Cerrar sesión")
                    .setMessage("¿Desea cerrar sesión?")
                    .setPositiveButton("Si") { _, _ ->
                        val intent = Intent(this, login::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                        finish()
                    }
                    .setNegativeButton("No", null)
                    .show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) ||
                super.onSupportNavigateUp()

    }
}