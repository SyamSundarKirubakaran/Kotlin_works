package com.bugscript.cycler.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bugscript.cycler.R
import com.bugscript.cycler.model.Category

class CategoryAdapter(context : Context, category : List<Category>) : BaseAdapter(){

    val category = category
    val context = context

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView : View

        categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item,null)

        val categoryImage : ImageView = categoryView.findViewById(R.id.categoryImage)
        val categoryName : TextView = categoryView.findViewById(R.id.categoryName)

        val selectedCategory = category[position]
        categoryName.text = selectedCategory.title

        val resouceId = context.resources.getIdentifier(selectedCategory.image,"drawable",context.packageName)
        categoryImage.setImageResource(resouceId)
        println(resouceId)

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return category[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return category.count()
    }

}