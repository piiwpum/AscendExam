package com.piiwpum.ascendexam.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.piiwpum.ascendexam.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, ProductListFragment.newInstance()).commitNow()
        }
    }
}