package com.bugscript.cycler.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bugscript.cycler.R
import com.bugscript.cycler.model.Product

class ProductAdapter(val context: Context, val productList : List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProductHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item,p0,false)
        return ProductHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.count()
    }

    override fun onBindViewHolder(p0: ProductHolder, p1: Int) {
        p0.bindProduct(context,productList[p1])
    }

    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val productName = itemView.findViewById<TextView>(R.id.ProductName)
        val productPrice = itemView.findViewById<TextView>(R.id.Price)
        val productImage = itemView.findViewById<ImageView>(R.id.imageView)

        fun bindProduct(context: Context, product: Product){
            val resourceId = context.resources.getIdentifier(product.image,"drawable",context.packageName)
            productImage.setImageResource(resourceId)
            productName.text = product.title
            productPrice.text = product.price
        }
    }

}