package com.piiwpum.ascendexam.di

import com.piiwpum.ascendexam.data.NetworkClient
import com.piiwpum.ascendexam.repo.ProductRepo
import com.piiwpum.ascendexam.viewmodel.ProductDetailViewModel
import com.piiwpum.ascendexam.viewmodel.ProductListViewModel
import org.koin.dsl.module

val networkModule = module {
    single { NetworkClient() }
    single { ProductRepo(get()) }
}

val appModule = module {
    single { ProductListViewModel(get()) }
    factory { ProductDetailViewModel(get()) }
}


