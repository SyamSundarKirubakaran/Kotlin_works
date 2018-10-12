package com.bugscript.cycler.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.bugscript.cycler.R
import com.bugscript.cycler.adapters.CategoryAdapter
import com.bugscript.cycler.model.Category
import com.bugscript.cycler.services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this,
                DataService.categories)

        CategoryListView.adapter = adapter
//
//        CategoryListView.setOnItemClickListener { adapterView, view, i, l ->
//            val category = DataService.categories[i]
//            Toast.makeText(this, "You just clicked on ${category.title}",Toast.LENGTH_LONG).show()
//        }
    }
}
