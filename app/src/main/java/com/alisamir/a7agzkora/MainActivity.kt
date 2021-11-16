package com.alisamir.a7agzkora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.alisamir.a7agzkora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var controller: NavController
    lateinit var appBar:AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBar)
        controller = Navigation.findNavController(this,R.id.fragmentContainerView)
        NavigationUI.setupWithNavController(binding.drawer,controller)
        appBar = AppBarConfiguration(controller.graph,binding.drawerLayout)
        setupActionBarWithNavController(controller,appBar)

    }

    override fun onSupportNavigateUp(): Boolean {
        return controller.navigateUp(appBar)||super.onSupportNavigateUp()
    }
    public fun enableDrawer(mode:Int){
        binding.drawerLayout.setDrawerLockMode(mode)
    }
}