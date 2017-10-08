package com.alexandercasal.devslopes.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.alexandercasal.devslopes.coderswag.R
import com.alexandercasal.devslopes.coderswag.model.Category

/**
 * Created by Alexander on 10/7/2017.
 */
class CategoryAdapter(val context: Context, val categories: List<Category>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val holder: ViewHolder
        val categoryView: View

        if (convertView == null) {
            categoryView = LayoutInflater
                    .from(context)
                    .inflate(R.layout.category_list_item, null)
            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.image_background)
            holder.categoryName = categoryView.findViewById(R.id.text_label)

            categoryView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }

        val category = categories[position]

        val resourceID = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        holder.categoryImage?.setImageResource(resourceID)
        holder.categoryName?.text = category.title

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0L
    }

    override fun getCount(): Int {
        return categories.count()
    }


    private class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null;
    }
}