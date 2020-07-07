package com.piiwpum.ascendexam.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.piiwpum.ascendexam.model.ProductModel
import com.piiwpum.ascendexam.repo.ProductRepo
import io.reactivex.android.schedulers.AndroidSchedulers

class ProductDetailViewModel(val productRepo: ProductRepo) : ViewModel() {
    private val _product: MutableLiveData<ProductModel> = MutableLiveData()
    var product: LiveData<ProductModel> = _product

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    var isLoading: LiveData<Boolean> = _isLoading

    private val _isError: MutableLiveData<Boolean> = MutableLiveData()
    var isError: LiveData<Boolean> = _isError


    fun fetchProductDetail(id: Int?) {
        _isLoading.value = true
        _isError.value = false
        productRepo.getProductDetail(id.toString())
            .subscribeOn(io.reactivex.schedulers.Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _isLoading.value = false
                _isError.value = false
                _product.value = it
            }, { t: Throwable? ->
                _isLoading.value = false
                _isError.value = true
            })


    }

}