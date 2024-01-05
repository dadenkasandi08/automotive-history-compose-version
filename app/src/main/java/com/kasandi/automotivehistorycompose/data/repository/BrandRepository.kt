package com.kasandi.automotivehistorycompose.data.repository

import com.kasandi.automotivehistorycompose.data.model.Brand
import com.kasandi.automotivehistorycompose.data.model.BrandData

class BrandRepository {
    fun getBrands(): List<Brand> {
        return BrandData.brands
    }

    fun searchBrands(query: String): List<Brand> {
        return BrandData.brands.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
}