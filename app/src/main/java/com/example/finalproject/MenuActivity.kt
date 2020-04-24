package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.finalproject.API.BeerMainActivity
import com.google.android.material.navigation.NavigationView
//import kotlinx.android.synthetic.main.activity_maps.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_beer.*

class MenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragmento2 = FragmentBeer()
        val fragmento3 = FragmentMaps()

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        when (item.itemId) {
            R.id.nav_profile -> {
                Toast.makeText(this, "Busqueda clicked", Toast.LENGTH_SHORT).show()


            }
            R.id.nav_messages -> {
               // Toast.makeText(this, "Mapa clicked", Toast.LENGTH_SHORT).show()
                val intent2 = Intent(this, MapsActivity::class.java)
                startActivity(intent2)
                /*transaction.replace(R.id.drawer_layout,fragmento3)
                transaction.addToBackStack(null)
                transaction.commit()*/
            }
            R.id.nav_friends -> {
                Toast.makeText(this, "Catalogo clicked", Toast.LENGTH_SHORT).show()
                val intent2 = Intent(this, BeerMainActivity::class.java)
                startActivity(intent2)


            }
            R.id.nav_update -> {
                Toast.makeText(this, "Update clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_logout -> {
                Toast.makeText(this, "Sign out clicked", Toast.LENGTH_SHORT).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
