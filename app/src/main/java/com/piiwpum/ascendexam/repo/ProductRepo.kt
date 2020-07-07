package com.piiwpum.ascendexam.repo

import com.piiwpum.ascendexam.data.NetworkClient
import com.piiwpum.ascendexam.data.ProductService
import com.piiwpum.ascendexam.model.ProductModel
import io.reactivex.Flowable

class ProductRepo constructor(private val networkClient: NetworkClient) : ProductService {

    override fun getProductList(): Flowable<MutableList<ProductModel>> =
        networkClient.getClient().getProductList()

    override fun getProductDetail(id: String): Flowable<ProductModel> =
        networkClient.getClient().getProductDetail(id)

}