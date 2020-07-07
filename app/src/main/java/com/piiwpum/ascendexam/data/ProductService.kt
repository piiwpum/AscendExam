package com.piiwpum.ascendexam.data

import com.piiwpum.ascendexam.model.ProductModel
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductService {
    @GET("/products")
    fun getProductList(): Flowable<MutableList<ProductModel>>

    @GET("/products/{id}")
    fun getProductDetail(@Path("id") id: String): Flowable<ProductModel>

}