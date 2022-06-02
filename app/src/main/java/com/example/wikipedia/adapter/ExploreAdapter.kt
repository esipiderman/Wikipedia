package com.example.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ItemExploreBinding

class ExploreAdapter(private val data:ArrayList<ItemPost>, val itemEvents: ItemEvents) :RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {
    lateinit var binding:ItemExploreBinding

    inner class ExploreViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView){

        fun bindData(itemPost : ItemPost){

            Glide
                .with(itemView.context)
                .load(itemPost.imgUrl)
                .into(binding.imgExplore)

            binding.txtExploreTitle.text = itemPost.txtTitle
            binding.txtExploreSubtitle.text = itemPost.txtSubTitle
            binding.txtExploreDetail.text = itemPost.txtDetail

            itemView.setOnClickListener {
                itemEvents.itemClicked(itemPost)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        binding = ItemExploreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExploreViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}