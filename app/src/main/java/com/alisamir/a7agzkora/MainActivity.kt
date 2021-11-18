package com.alisamir.a7agzkora

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.alisamir.a7agzkora.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

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
        NavigationUI.setupWithNavController(binding.bottomNav,controller)
        controller.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){
                R.id.favoritesFragment,R.id.gamesFragment->{
                    binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                }
                else ->binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            }
        }
        binding.drawer.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.favoritesFragment -> controller.navigate(R.id.action_homeFragment_to_favoritesFragment)
                R.id.gamesFragment->controller.navigate(R.id.action_homeFragment_to_gamesFragment)
                R.id.settings->{Snackbar.make(binding.root,"Settings opened",Snackbar.LENGTH_SHORT).show()
                                binding.drawerLayout.closeDrawer(GravityCompat.START)}
                R.id.info->{
                                val alertDialog = AlertDialog.Builder(this)
                                    .setIcon(R.drawable.ic_launcher_foreground)
                                    .setMessage("Ali Samir, from Egypt have a good experience in android development and made good apps")
                                    .setPositiveButton("Ok",object :DialogInterface.OnClickListener{
                                        override fun onClick(p0: DialogInterface?, p1: Int) {
                                        }

                                    })
                                    .show()
                                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                            }
                R.id.rate->{
                                val rateIntent = Intent(Intent.ACTION_VIEW)
                                rateIntent.data = Uri.parse("https://play.google.com/store/apps/details?id=com.twitter.android")
                                startActivity(rateIntent)
                                binding.drawerLayout.closeDrawer(GravityCompat.START)
                            }
                R.id.share->{
                                val shareIntent = Intent(Intent.ACTION_SEND)
                                shareIntent.putExtra(Intent.EXTRA_TEXT,"Check out my app from this link:https://play.google.com/store/apps/details?id=com.twitter.android")
                                shareIntent.type = "text/plain"
                                startActivity(Intent.createChooser(shareIntent,"Choose the app you want:"))
                                binding.drawerLayout.closeDrawer(GravityCompat.START)
                            }
            }
            true
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return controller.navigateUp(appBar)||super.onSupportNavigateUp()
    }
    public fun enableDrawer(mode:Int){
        binding.drawerLayout.setDrawerLockMode(mode)
    }
}