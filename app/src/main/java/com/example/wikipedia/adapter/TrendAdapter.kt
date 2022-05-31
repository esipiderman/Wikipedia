package com.example.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ItemTrendBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class TrendAdapter(private val data:ArrayList<ItemPost>) :RecyclerView.Adapter<TrendAdapter.TrendViewHolder>() {
    lateinit var binding:ItemTrendBinding

    inner class TrendViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView){

        fun bindData(itemPost : ItemPost){

            Glide
                .with(itemView.context)
                .load(itemPost.imgUrl)
                .transform(RoundedCornersTransformation(42, 8))
                .into(binding.imgItemTrend)

            binding.txtTitleItemTrend.text = itemPost.txtTitle
            binding.txtSubtitleItemTrend.text = itemPost.txtSubTitle
            binding.txtTrendInsight.text = itemPost.insight
            binding.txtTrendNumber.text = (adapterPosition + 1).toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {
        binding = ItemTrendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrendViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}