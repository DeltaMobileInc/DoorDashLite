package com.example.doordashlite.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.doordashlite.model.ApiResponse
import com.example.doordashlite.model.Store
import com.example.doordashlite.viewmodel.RestaurantViewModel

class RestaurantsAdapter(
    private val viewModel: RestaurantViewModel,
    private var storeList: List<Store> = listOf()
) :
    RecyclerView.Adapter<RestaurantViewHolder>() {

    fun setItems(restaurantsList: List<Store>) {
        storeList = restaurantsList
        notifyDataSetChanged()
    }

    override fun getItemCount() = storeList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RestaurantViewHolder.create(parent, viewModel)

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind(storeList[position])
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val visibleItemCount: Int? = recyclerView.layoutManager?.childCount
                val totalVisibleItems: Int? = recyclerView.layoutManager?.itemCount
                val pastVisiblesItems: Int? = (recyclerView.layoutManager as? LinearLayoutManager)
                    ?.findFirstVisibleItemPosition()
                if (visibleItemCount == null || totalVisibleItems == null || pastVisiblesItems == null) return
                viewModel.firstVisibleItem = pastVisiblesItems
                if (visibleItemCount + pastVisiblesItems >= totalVisibleItems) {
                    viewModel.getRestaurantsList(storeList.size)
                }
            }
        })
    }
}