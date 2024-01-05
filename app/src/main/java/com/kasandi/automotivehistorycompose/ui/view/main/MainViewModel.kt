package com.kasandi.automotivehistorycompose.ui.view.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.kasandi.automotivehistorycompose.data.model.Brand
import com.kasandi.automotivehistorycompose.data.repository.BrandRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(private val brandRepository: BrandRepository) : ViewModel() {

    private val _brands = MutableStateFlow(
        brandRepository.getBrands()
    )

    val brands: StateFlow<List<Brand>> get() = _brands

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _brands.value = brandRepository.searchBrands(_query.value)
    }
}