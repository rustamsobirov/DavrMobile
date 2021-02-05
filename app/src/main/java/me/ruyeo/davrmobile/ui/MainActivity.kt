package me.ruyeo.davrmobile.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import me.ruyeo.davrmobile.R
import me.ruyeo.davrmobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_main)

        binding.bottomNav.selectedItemId = R.id.action_cards
        binding.bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_profile -> Toast.makeText(this,"clicked profile",Toast.LENGTH_SHORT).show()
                R.id.action_chat -> Toast.makeText(this,"clicked chat",Toast.LENGTH_SHORT).show()
                R.id.action_home -> navController.navigate(R.id.homeFragment)
                R.id.action_cards -> navController.navigate(R.id.myCardsFragment)
                R.id.action_perevod -> Toast.makeText(this,"clicked perevod",Toast.LENGTH_SHORT).show()
            }
            true
        }


    }
}