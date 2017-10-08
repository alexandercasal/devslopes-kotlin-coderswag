package com.alexandercasal.devslopes.coderswag.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.alexandercasal.devslopes.coderswag.R
import com.alexandercasal.devslopes.coderswag.model.Product

/**
 * Created by Alexander on 10/7/2017.
 */
class ProductsAdapter(val context: Context, val products: List<Product>) : RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {

    override fun onBindViewHolder(holder: ProductHolder?, position: Int) {
        holder?.bindProduct(context, products[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProductHolder {
        val view = LayoutInflater
                .from(context)
                .inflate(R.layout.product_list_item, parent, false)
        return ProductHolder(view)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    inner class ProductHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val image = itemView?.findViewById<ImageView>(R.id.image_product)
        val name = itemView?.findViewById<TextView>(R.id.text_product)
        val price = itemView?.findViewById<TextView>(R.id.text_price)

        fun bindProduct(context: Context, product: Product) {
            val resourceID = context.resources.getIdentifier(
                    product.image,
                    "drawable",
                    context.packageName
            )
            image?.setImageResource(resourceID)
            name?.text = product.title
            price?.text = product.price
        }
    }
}