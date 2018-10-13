package com.bugscript.cycler.controller

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import android.widget.Toast
import com.bugscript.cycler.R
import com.bugscript.cycler.Utilities.EXTRA_CATEGORY
import com.bugscript.cycler.adapters.CategoryAdapter
import com.bugscript.cycler.adapters.CategoryRecyclerAdapter
import com.bugscript.cycler.model.Category
import com.bugscript.cycler.services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecyclerAdapter(this,
                DataService.categories) { Category ->
            val productIntent = Intent(this,ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, Category.title)
            startActivity(productIntent)
        }

        CategoryListView.adapter = adapter

        val orientation = resources.configuration.orientation

        var spanCount : Int = when(orientation){
            Configuration.ORIENTATION_PORTRAIT -> 1
            Configuration.ORIENTATION_LANDSCAPE -> 2
            else -> 1
        }

        val screenSize = resources.configuration.screenWidthDp

        if(screenSize>720){
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this,spanCount)
        CategoryListView.layoutManager = layoutManager


    }
}
