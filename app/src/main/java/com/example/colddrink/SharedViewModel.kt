package com.example.colddrink

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private var _quantity = MutableLiveData<String>()
    val quantity : LiveData<String> = _quantity

    private var _brand = MutableLiveData<String>()
    val brand : LiveData<String> get() = _brand

    private var _date = MutableLiveData<String>()
    val date : LiveData<String> = _date

    private val _price = MutableLiveData<Double>()
    val price: LiveData<Double> = _price

    fun setQuantity(q : String) {
        _quantity.value = q
    }

    fun setBrand(selectedBrand : String) {
        _brand.value = selectedBrand
    }

    fun setDate(pickupDate : String) {
        _date.value = pickupDate
    }
}
