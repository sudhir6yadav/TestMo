package com.sd.testmo.data.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.sd.testmo.data.entities.Item
import com.sd.testmo.data.repository.ItemRepository
import com.sd.testmo.utils.Resource

class ItemDetailViewModel @ViewModelInject constructor(private val repository: ItemRepository) : ViewModel() {

    private val _id = MutableLiveData<Int>()

    private val _items = _id.switchMap { id ->
        repository.getItems(id)
    }
    val items: LiveData<Resource<Item>> = _items


    fun start(id: Int) {
        _id.value = id
    }

}
