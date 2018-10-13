package com.bugscript.cycler.controller

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import com.bugscript.cycler.R
import com.bugscript.cycler.Utilities.EXTRA_CATEGORY
import com.bugscript.cycler.adapters.ProductAdapter
import com.bugscript.cycler.services.DataService
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val category_type = intent.getStringExtra(EXTRA_CATEGORY)
        Toast.makeText(this,"Traversed on ${category_type}",Toast.LENGTH_LONG).show()

        adapter = ProductAdapter(this,DataService.getProducts(category_type))

        ProductsListView.adapter = adapter

        val orientation = resources.configuration.orientation

        val spanCount : Int = when(orientation){
           Configuration.ORIENTATION_PORTRAIT -> 2
            Configuration.ORIENTATION_LANDSCAPE -> 3
            else -> 2
        }


        val layoutManager = GridLayoutManager(this,spanCount)
        ProductsListView.layoutManager = layoutManager

    }
}
