package com.alexandercasal.devslopes.coderswag.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alexandercasal.devslopes.coderswag.R
import com.alexandercasal.devslopes.coderswag.adapters.CategoryAdapter
import com.alexandercasal.devslopes.coderswag.services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(
                this,
                DataService.categories
        )
        list_categories.adapter = adapter
    }
}
