package com.example.colddrink

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

private const val PRICE_FOR_SAME_DAY_PICKUP = 10

class SharedViewModel : ViewModel() {

    private var _quantity = MutableLiveData<String>()
    val quantity : LiveData<String> = _quantity

    private var _brand = MutableLiveData<String>()
    val brand : LiveData<String> get() = _brand

    private var _date = MutableLiveData<String>()
    val date : LiveData<String> = _date

    private val _price = MutableLiveData<Double>()
    val price: LiveData<Double> = _price

    val dateOptions = getPickupOptions()

    fun setQuantity(q : String) {
        _quantity.value = q
    }

    fun setBrand(selectedBrand : String) {
        _brand.value = selectedBrand
    }

    fun setDate(pickupDate : String) {
        _date.value = pickupDate
        updatePrice(0)
    }

    fun isBrandSelected() : Boolean {
        return _brand.value.isNullOrBlank()
    }

    private fun getPickupOptions(): List<String> {

        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()

        val options = mutableListOf<String>()
        repeat(4) {
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }

        return options
    }

    fun updatePrice(p : Int) {
        var currentPrice = p * 0.1
        if(_date.value == dateOptions[0]) {
            currentPrice += PRICE_FOR_SAME_DAY_PICKUP
        }

        _price.value = currentPrice
    }
}
