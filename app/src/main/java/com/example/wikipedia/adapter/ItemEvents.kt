package com.example.wikipedia.adapter

import com.example.wikipedia.data.ItemPost

interface ItemEvents {
    fun itemClicked(itemPost: ItemPost)
}