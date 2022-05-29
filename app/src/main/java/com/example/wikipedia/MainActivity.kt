package com.example.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.wikipedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //-------------SET TOOL BAR------------
        setSupportActionBar(binding.toolbarMain)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerMain,
            binding.toolbarMain,
            R.string.open_drawer,
            R.string.close_drawer
        )

        actionBarDrawerToggle.syncState()
        binding.drawerMain.addDrawerListener( actionBarDrawerToggle )

        binding.navigationViewMain.setNavigationItemSelectedListener {

            when (it.itemId){
                R.id.menu_writer ->{

                    binding.drawerMain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_photographer ->{

                    binding.drawerMain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_video_maker ->{

                    binding.drawerMain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_translator ->{

                    binding.drawerMain.closeDrawer(GravityCompat.START)
                }

                //---------------------------------------

                R.id.menu_open_wikipedia ->{

                    binding.drawerMain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_open_wikimedia ->{

                    binding.drawerMain.closeDrawer(GravityCompat.START)
                }

            }

            true
        }
    }
}