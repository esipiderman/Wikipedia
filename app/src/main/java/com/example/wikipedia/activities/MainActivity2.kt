package com.example.wikipedia.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ActivityMain2Binding
import com.example.wikipedia.fragments.SEND_DATA_TO_ACTIVITY2

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarDetail)
        binding.collapsingDetail.setExpandedTitleColor(
            ContextCompat.getColor(this, android.R.color.transparent)
        )
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        val dataPost = intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_ACTIVITY2)
        if (dataPost != null){
            showData(dataPost)
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home){
            onBackPressed()
        }

        return true
    }

    fun showData(itemPost: ItemPost){
        Glide
            .with(this)
            .load(itemPost.imgUrl)
            .into(binding.imgDetail)

        val title = itemPost.txtTitle

        binding.txtDetailTitle.text = title
        binding.txtDetailSubtitle.text = itemPost.txtSubTitle
        binding.txtDetailText.text = itemPost.txtDetail

        binding.fabDetail.setOnClickListener {
            var url = "https://en.wikipedia.org/wiki/"
            var newTitle = title.replace("'", "%27")

            val splitedTitle = newTitle.split(" ")
            if (splitedTitle.size == 1){
                url = "https://en.wikipedia.org/wiki/$newTitle"
            }else{
                for (i in 0 until (splitedTitle.size - 1)){
                    url = url + splitedTitle[i] + "_"
                }
                url += splitedTitle[splitedTitle.size - 1]
            }

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}