package com.example.doordashlite.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.doordashlite.R
import com.example.doordashlite.model.ApiResponse
import com.example.doordashlite.model.Store
import com.example.doordashlite.viewmodel.RestaurantViewModel
import kotlinx.android.synthetic.main.item_restaurant.view.*

class RestaurantViewHolder(view: View, private val viewModel: RestaurantViewModel) : RecyclerView.ViewHolder(view) {

    fun bind(store: Store) {
        itemView.name.text = store.name
        itemView.coverImage.scaleType = ImageView.ScaleType.CENTER_CROP
        Glide.with(itemView.context)
            .load(store.headerImgUrl)
            .placeholder(R.mipmap.ic_launcher_round)
            .error(R.mipmap.ic_launcher_round)
            .into(itemView.coverImage)
        //set on click listener for the view
    }

    companion object {
        fun create(parent: ViewGroup, viewModel: RestaurantViewModel) = RestaurantViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_restaurant, parent, false), viewModel
        )
    }
}