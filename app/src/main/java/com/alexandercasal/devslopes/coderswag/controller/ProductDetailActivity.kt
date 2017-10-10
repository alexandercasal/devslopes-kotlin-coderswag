package com.alexandercasal.devslopes.coderswag.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alexandercasal.devslopes.coderswag.R
import com.alexandercasal.devslopes.coderswag.model.Product
import com.alexandercasal.devslopes.coderswag.utils.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        val resourceID = this.resources.getIdentifier(product.image, "drawable", this.packageName)
        image_product.setImageResource(resourceID)
        text_product_name.text = "Item: ${product.title}"
        text_price.text = "Price: ${product.price}"
        text_description.text = """Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum.
            |Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum.
            |Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum. Lorem Ipsum.
            | Lorem Ipsum. Lorem Ipsum.""".trimMargin()
    }
}
