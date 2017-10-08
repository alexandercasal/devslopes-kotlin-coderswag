package com.alexandercasal.devslopes.coderswag.controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.alexandercasal.devslopes.coderswag.R
import com.alexandercasal.devslopes.coderswag.adapters.CategoryRecycleAdapter
import com.alexandercasal.devslopes.coderswag.services.DataService
import com.alexandercasal.devslopes.coderswag.utils.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories) { category ->
            val intent = Intent(this, ProductsActivity::class.java)
            intent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(intent)
        }
        list_categories.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        list_categories.layoutManager = layoutManager
        list_categories.setHasFixedSize(true)


    }
}
