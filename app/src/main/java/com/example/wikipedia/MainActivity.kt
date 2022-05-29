package com.example.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.wikipedia.databinding.ActivityMainBinding
import com.example.wikipedia.fragments.FragmentExplore
import com.example.wikipedia.fragments.FragmentProfile
import com.example.wikipedia.fragments.FragmentTrend

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //-------------SET TOOL BAR------------
        setSupportActionBar(binding.toolbarMain)

        //--------------SET NAVIGATION DRAWER-----------
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerMain,
            binding.toolbarMain,
            R.string.open_drawer,
            R.string.close_drawer
        )

        actionBarDrawerToggle.syncState()
        binding.drawerMain.addDrawerListener( actionBarDrawerToggle )

        //--------------ITEMS OF NAVIGATION DRAWER------------
        binding.navigationViewMain.setNavigationItemSelectedListener {

            when (it.itemId){
                R.id.menu_writer ->{

                    binding.drawerMain.closeDrawer(GravityCompat.END)
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

        //---------------SET BOTTOM NAVIGATION------------
        firstRun()

        //--------------ITEMS OF NAVIGATION BOTTOM-------------
        binding.bottomNavigationMain.setOnItemSelectedListener {

            when(it.itemId){

                R.id.menu_explore ->{
                    replaceFragment(FragmentExplore())
                }

                R.id.menu_trend ->{
                    replaceFragment(FragmentTrend())
                }

                R.id.menu_profile ->{
                    replaceFragment(FragmentProfile())
                }

            }

            true
        }
        binding.bottomNavigationMain.setOnItemReselectedListener {  }
    }

    fun replaceFragment(fragment : Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container, fragment)
        transaction.commit()
    }

    fun firstRun(){
        replaceFragment(FragmentExplore())
        binding.bottomNavigationMain.selectedItemId = R.id.menu_explore
    }
}