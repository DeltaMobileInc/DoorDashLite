package com.example.doordashlite.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doordashlite.R
import com.example.doordashlite.viewmodel.RestaurantViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: RestaurantViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(RestaurantViewModel::class.java)

        val adapter = RestaurantsAdapter(viewModel)
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        list.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        list.adapter = adapter
        viewModel.restLiveData.observe(this, Observer {
            adapter.setItems(it)
        })

        viewModel.firstVisibleItem?.let {
            //Take users to where they were
            list.scrollToPosition(it)
        } ?: run {
            viewModel.getRestaurantsList(0)
        }
    }
}