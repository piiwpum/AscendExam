package com.piiwpum.ascendexam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.piiwpum.ascendexam.R
import kotlinx.android.synthetic.main.product_detail_activity.*

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_detail_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ProductDetailFragment.newInstance()).commitNow()
        }
        btn_back?.setOnClickListener { onBackPressed() }
    }
}