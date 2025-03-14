package com.uilover.project2192.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.uilover.project2192.Adapter.BestSellerAdapter
import com.uilover.project2192.Adapter.CategoryAdapter
import com.uilover.project2192.ViewModel.MainViewModel
import com.uilover.project2192.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private val viewModel = MainViewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCategories()
        initBestSeller()
        bottomNavigation()

    }

    private fun bottomNavigation() {
        binding.cartBtn.setOnClickListener {
            startActivity(Intent(this,CartActivity::class.java))
        }
    }

    private fun initBestSeller() {
        binding.progressBarBestSeller.visibility = View.VISIBLE
        viewModel.bestSeller.observe(this, Observer {
            binding.viewBestSeller.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            binding.viewBestSeller.adapter = BestSellerAdapter(it)
            binding.progressBarBestSeller.visibility = View.GONE
        })
    }

    private fun initCategories() {
        binding.progressBarCategory.visibility = View.VISIBLE
        viewModel.category.observe(this, Observer {
            binding.viewCategory.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            binding.viewCategory.adapter = CategoryAdapter(it)
            binding.progressBarCategory.visibility = View.GONE
        })
    }


}