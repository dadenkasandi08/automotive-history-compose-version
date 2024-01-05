package com.kasandi.automotivehistorycompose.helper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kasandi.automotivehistorycompose.data.repository.BrandRepository
import com.kasandi.automotivehistorycompose.ui.view.main.MainViewModel

class ViewModelFactory(private val repository: BrandRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}