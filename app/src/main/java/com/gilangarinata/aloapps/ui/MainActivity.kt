package com.gilangarinata.aloapps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.gilangarinata.aloapps.R
import com.gilangarinata.aloapps.databinding.ActivityMainBinding

/**
 * Created by Gilang Arinata on 20/03/21.
 * https://github.com/gilangarinata/
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val navigationController = supportFragmentManager.findFragmentByTag("fragment_sheet_main")?.findNavController()
        navigationController?.let {
            binding.bottomNavigationView.setupWithNavController(it)
            it.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.homeFragment -> showBottomNav()
                    R.id.profileFragment -> showBottomNav()
                    else -> hideBottomNav()
                }
            }
        }
    }

    private fun showBottomNav() {
       binding.bottomNavigationView.visibility = View.VISIBLE
    }

    private fun hideBottomNav() {
        binding.bottomNavigationView.visibility = View.GONE
    }
}