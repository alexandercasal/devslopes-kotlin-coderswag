package com.alexandercasal.devslopes.coderswag.controller

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.alexandercasal.devslopes.coderswag.R
import com.alexandercasal.devslopes.coderswag.adapters.ProductsAdapter
import com.alexandercasal.devslopes.coderswag.services.DataService
import com.alexandercasal.devslopes.coderswag.utils.EXTRA_CATEGORY
import com.alexandercasal.devslopes.coderswag.utils.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val category = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(category)) { product ->
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra(EXTRA_PRODUCT, product)
            startActivity(intent)
        }

        val orientation = resources.configuration.orientation
        var spanCount = when(orientation) {
            Configuration.ORIENTATION_PORTRAIT -> 2
            Configuration.ORIENTATION_LANDSCAPE -> 3
            else -> 2
        }

        val screenSize = resources.configuration.screenWidthDp
        if (screenSize > 720) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        list_products.layoutManager = layoutManager
        list_products.adapter = adapter


    }
}
