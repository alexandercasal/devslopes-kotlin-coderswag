package com.alexandercasal.devslopes.coderswag.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.alexandercasal.devslopes.coderswag.R
import com.alexandercasal.devslopes.coderswag.model.Category
import com.alexandercasal.devslopes.coderswag.services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ArrayAdapter<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                DataService.categories
        )
        list_categories.adapter = adapter
    }
}
