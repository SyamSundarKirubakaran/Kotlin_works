package com.bugscript.cycler.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bugscript.cycler.R
import com.bugscript.cycler.R.id.categoryImage
import com.bugscript.cycler.R.id.categoryName
import com.bugscript.cycler.model.Category

class CategoryAdapter(val context : Context, val category : List<Category>) : BaseAdapter(){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView : View
        val holder : ViewHolder

        if(convertView == null) {
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)
            categoryView.tag = holder
            println("Inside IF")
        } else {
            holder = convertView.tag as ViewHolder
            categoryView = convertView
            println("Inside Else")
        }

        val selectedCategory = category[position]
        holder.categoryName?.text = selectedCategory.title

        val resouceId = context.resources.getIdentifier(selectedCategory.image,"drawable",context.packageName)
        holder.categoryImage?.setImageResource(resouceId)
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

    class ViewHolder {
        var categoryImage : ImageView? = null
        var categoryName : TextView? = null
    }

}