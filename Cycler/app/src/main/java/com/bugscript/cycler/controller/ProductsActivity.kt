package com.bugscript.cycler.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bugscript.cycler.R
import com.bugscript.cycler.Utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val category_type = intent.getStringExtra(EXTRA_CATEGORY)
        Toast.makeText(this,"Traversed on ${category_type}",Toast.LENGTH_LONG).show()
    }
}
