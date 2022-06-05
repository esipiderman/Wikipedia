package com.example.wikipedia.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.wikipedia.R
import com.example.wikipedia.databinding.ActivityMainBinding
import com.example.wikipedia.fragments.FragmentExplore
import com.example.wikipedia.fragments.FragmentPhotographer
import com.example.wikipedia.fragments.FragmentProfile
import com.example.wikipedia.fragments.FragmentTrend
import com.google.android.material.snackbar.Snackbar

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

                    binding.drawerMain.closeDrawer(GravityCompat.START)

                    val dialog = SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Alert!")
                        .setCancelText("No!")
                        .setConfirmText("Yes")
                        .setContentText("You really wanna be a writer?")

                    dialog.setCancelClickListener {
                        dialog.dismiss()
                    }
                    dialog.setConfirmClickListener {
                        dialog.dismiss()
                        val url = "https://en.wikipedia.org/wiki/Writer"
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        startActivity(intent)
                    }
                    dialog.show()
                }

                R.id.menu_photographer ->{
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.add(R.id.frame_main_container, FragmentPhotographer() )
                    transaction.addToBackStack(null)
                    transaction.commit()

                    binding.navigationViewMain.menu.getItem(1).isChecked = true

                    binding.drawerMain.closeDrawer(GravityCompat.START)
                }

                R.id.menu_video_maker ->{
                    binding.drawerMain.closeDrawer(GravityCompat.START)

                    Snackbar
                        .make(binding.root, "No internet connection!", Snackbar.LENGTH_LONG)
                        .setAction("Retry"){
                            Toast.makeText(this, "checking network", Toast.LENGTH_SHORT).show()
                        }
                        .setActionTextColor(ContextCompat.getColor(this, R.color.white))
                        .setBackgroundTint(ContextCompat.getColor(this, R.color.Blue))
                        .show()
                }

                R.id.menu_translator ->{

                    binding.drawerMain.closeDrawer(GravityCompat.START)
                    val intent = Intent(this, MainActivity3::class.java)
                    startActivity(intent)

                }

                //---------------------------------------

                R.id.menu_open_wikipedia ->{

                    binding.drawerMain.closeDrawer(GravityCompat.START)
                    openWebsite("https://www.wikipedia.org/")
                }

                R.id.menu_open_wikimedia ->{

                    binding.drawerMain.closeDrawer(GravityCompat.START)
                    openWebsite("https://www.wikimedia.org/")
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
            binding.navigationViewMain.menu.getItem(1).isChecked = false

            true
        }
        binding.bottomNavigationMain.setOnItemReselectedListener {  }
    }

    private fun replaceFragment(fragment : Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container, fragment)
        transaction.commit()
    }

    private fun firstRun(){
        replaceFragment(FragmentExplore())
        binding.bottomNavigationMain.selectedItemId = R.id.menu_explore
    }

    override fun onBackPressed() {
        super.onBackPressed()

        binding.navigationViewMain.menu.getItem(1).isChecked = false
    }

    private fun openWebsite(url: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when ( item.itemId ){

            R.id.menu_exit->{
                onBackPressed()
            }

        }


        return true
    }

}