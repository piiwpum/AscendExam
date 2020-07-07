package com.piiwpum.ascendexam.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.piiwpum.ascendexam.model.ProductModel
import com.piiwpum.ascendexam.repo.ProductRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ProductListViewModel(val productRepo: ProductRepo) : ViewModel() {
    private val _productLs: MutableLiveData<MutableList<ProductModel>> = MutableLiveData()
    var productLs: LiveData<MutableList<ProductModel>> = _productLs

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    var isLoading: LiveData<Boolean> = _isLoading

    private val _isError: MutableLiveData<Boolean> = MutableLiveData()
    var isError: LiveData<Boolean> = _isError

    init {
        fetchProductList()
    }

    fun fetchProductList() {
        _isLoading.value = true
        _isError.value = false
        productRepo.getProductList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _isLoading.value = false
                _isError.value = false
                _productLs.value = it
            }, { t: Throwable? ->
                _isLoading.value = false
                _isError.value = true
            })

    }

}