package com.example.mvcexample2.model

import java.util.*
import kotlin.collections.ArrayList

class Model : Observable() {

    private val List : MutableList<Int>

    init {

        List = ArrayList(3)

        List.add(0)
        List.add(0)
        List.add(0)

    }
    // defining getter and setter functions
    // function to return appropriate count
    // value at correct index
    @Throws(IndexOutOfBoundsException::class)
    fun getValueAtIndex(the_index: Int): Int {
        return List[the_index]
    }

    // function to make changes in the activity button's
    // count value when user touch it
    @Throws(IndexOutOfBoundsException::class)
    fun setValueAtIndex(the_index: Int) {
        List[the_index] = List[the_index] + 1
        setChanged()
        notifyObservers()
    }
}