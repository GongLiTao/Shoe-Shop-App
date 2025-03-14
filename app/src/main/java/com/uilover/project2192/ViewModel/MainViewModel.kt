package com.uilover.project2192.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.uilover.project2192.Model.CategoryModel
import com.uilover.project2192.Model.ItemsModel
import com.uilover.project2192.Repository.MainRepository

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    val category: LiveData<MutableList<CategoryModel>> = repository.loadCategory()
    val bestSeller: LiveData<MutableList<ItemsModel>> = repository.loadBestSeller()

    fun loadItems(categoryId: String): LiveData<MutableList<ItemsModel>> {
        return repository.loadItems(categoryId)
    }
}