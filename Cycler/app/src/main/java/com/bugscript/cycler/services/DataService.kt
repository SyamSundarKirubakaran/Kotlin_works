package com.bugscript.cycler.services

import com.bugscript.cycler.model.Category
import com.bugscript.cycler.model.Product

object DataService {

    val categories = listOf(
            Category("Shirt","shirtImage"),
            Category("Hoodies","hoodyImage"),
            Category("Hats","hatsImage"),
            Category("Digital","digitalImage")
    )

    val hats = listOf(
            Product("a","1","hat1"),
            Product("b","2","hat2"),
            Product("c","3","hat3"),
            Product("d","4","hat4")
    )

    val hoodies = listOf(
            Product("e","5","hoodie1"),
            Product("f","6","hoodie2"),
            Product("g","7","hoodie3"),
            Product("h","8","hoodie4")
    )

    val shirts = listOf(
            Product("i","9","shirt1"),
            Product("j","10","shirt2"),
            Product("k","11","shirt3"),
            Product("l","12","shirt4")
    )

}