package com.uilover.project2192.Activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.uilover.project2192.Adapter.ListItemsAdapter
import com.uilover.project2192.ViewModel.MainViewModel
import com.uilover.project2192.databinding.ActivityListItemsBinding

class ListItemsActivity : BaseActivity() {
    lateinit var binding: ActivityListItemsBinding
    private val viewModel = MainViewModel()
    private var id: String = ""
    private var title: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getBundle()
        initList()

    }

    private fun initList() {
        binding.apply {
            progressBar.visibility = View.VISIBLE
            viewModel.loadItems(id).observe(this@ListItemsActivity, Observer {
                listView.layoutManager =
                    LinearLayoutManager(this@ListItemsActivity, LinearLayoutManager.VERTICAL, false)
                listView.adapter = ListItemsAdapter(it)
                progressBar.visibility = View.GONE
            })

            backBtn.setOnClickListener { finish() }
        }
    }

    private fun getBundle() {
        id = intent.getStringExtra("id")!!
        title = intent.getStringExtra("title")!!

        binding.categoryTxt.text = title
    }
}