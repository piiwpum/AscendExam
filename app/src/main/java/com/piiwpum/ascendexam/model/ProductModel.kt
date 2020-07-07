package com.piiwpum.ascendexam.model

data class ProductModel(
    val content: String,
    val id: Int,
    val image: String,
    val isNewProduct: Boolean,
    val price: Double,
    val title: String
)