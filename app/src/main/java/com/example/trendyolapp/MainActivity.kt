package com.example.trendyolapp

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.trendyolapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val navHostFragment1 = supportFragmentManager.findFragmentById(R.id.navHostFragment1) as NavHostFragment
        val navController = navHostFragment1.navController

        NavigationUI.setupWithNavController(binding.bottomNavigationBar, navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.siparislerimFragment, R.id.siparisOnaylandiFragment, R.id.sepetimFragment, R.id.odemeSayfasiFragment -> binding.bottomNavigationBar.visibility = View.GONE
                else -> binding.bottomNavigationBar.visibility = View.VISIBLE
            }
        }
    }
}
