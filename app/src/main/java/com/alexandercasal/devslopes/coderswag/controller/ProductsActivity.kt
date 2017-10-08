package com.alexandercasal.devslopes.coderswag.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alexandercasal.devslopes.coderswag.R
import com.alexandercasal.devslopes.coderswag.utils.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val category = intent.getStringExtra(EXTRA_CATEGORY)
        println(category)
    }
}
