package com.example.wikipedia.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ActivityMain3Binding


class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarTranslate)
        binding.collapsingTranslate.setExpandedTitleColor(
            ContextCompat.getColor(this, android.R.color.transparent)
        )
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val data = ItemPost(
            "https://www.atanet.org/wp-content/uploads/bb-plugin/cache/so-you-want-to-be-a-translator-panorama.jpg",
        "So, You Want To Be A Translator?",
        "February 9, 2021",
        "This post originally appeared on The Detail Woman blog and it is republished with permission. There are two main things I want to do on this page: first, I want to say a few things to people considering entering the translation profession. Mostly I want to clear up some misconceptions, but there are also some things I just plain think everyone who’s contemplating or practicing translation needs to hear. Second, for people interested in what kind of background you need or steps you can take to become a kickass translator, I want to talk a little bit about the skills needed and how to go about getting them. \nI write this page not with the assumption that I am The Kickass Translator of All Time, but with the knowledge that I am still growing and that every single thing I say still applies to me and always will. In fact, I hope I’ll always be growing as a translator. That’s the way it’s supposed to be. But in my career I’ve had the opportunity to be on both sides of the process: on one side the translator being evaluated and working under supervision, and on the other side the person evaluating translators–both making recommendations on hires and quality checking other people’s work. It’s a somewhat unique set of experiences and it’s let me see a lot of things about the translating processes of myself and others, and about new translators I see entering the field.",
        false,
        "")
        showData(data)


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
            .into(binding.imgTranslate)

        binding.txtTranslateTitle.text = itemPost.txtTitle
        binding.txtTranslateSubtitle.text = itemPost.txtSubTitle
        binding.txtTranslateText.text = itemPost.txtDetail

        binding.fabTranslate.setOnClickListener {
            var url = "https://www.atanet.org/starting-your-career/you-want-to-be-translator/"

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

    }
}