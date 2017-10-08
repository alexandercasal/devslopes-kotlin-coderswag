package com.alexandercasal.devslopes.coderswag.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import com.alexandercasal.devslopes.coderswag.R
import com.alexandercasal.devslopes.coderswag.adapters.CategoryAdapter
import com.alexandercasal.devslopes.coderswag.adapters.CategoryRecycleAdapter
import com.alexandercasal.devslopes.coderswag.services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this,DataService.categories)
        list_categories.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        list_categories.layoutManager = layoutManager
        list_categories.setHasFixedSize(true)
    }
}
