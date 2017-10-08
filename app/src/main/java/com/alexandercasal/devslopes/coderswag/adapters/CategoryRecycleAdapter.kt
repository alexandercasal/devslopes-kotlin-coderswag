package com.alexandercasal.devslopes.coderswag.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.alexandercasal.devslopes.coderswag.R
import com.alexandercasal.devslopes.coderswag.model.Category

/**
 * Created by Alexander on 10/7/2017.
 */
class CategoryRecycleAdapter(val context: Context, val categories: List<Category>, val itemClick: (Category) -> Unit)
    : RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {

    override fun getItemCount(): Int {
        return categories.count()
    }

    /**
     * Prepares child view to display info corresponding to its position in the adapter
     */
    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bindCategory(context, categories[position])

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.category_list_item, parent, false)
        return Holder(view, itemClick)
    }

    inner class Holder(itemView: View?, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val categoryImage = itemView?.findViewById<ImageView>(R.id.image_background)
        val categoryName = itemView?.findViewById<TextView>(R.id.text_label)

        fun bindCategory(context: Context, category: Category) {
            val resourceID = context.resources.getIdentifier(category.image,
                    "drawable", context.packageName
            )
            categoryImage?.setImageResource(resourceID)
            categoryName?.text = category.title

            itemView.setOnClickListener { itemClick(category) }
        }
    }
}