package com.example.mvcexample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvcexample2.databinding.ActivityMainBinding
import com.example.mvcexample2.model.Model
import java.util.*

class MainActivity : AppCompatActivity() ,  Observer {

    private lateinit var mBinding : ActivityMainBinding
    var myModel : Model? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        myModel = Model()
        myModel!!.addObserver(this)

        mBinding.btn1.setOnClickListener {  myModel?.setValueAtIndex(0)}
        mBinding.btn2.setOnClickListener {  myModel?.setValueAtIndex(1) }
        mBinding.btn3.setOnClickListener {   myModel?.setValueAtIndex(2)}

    }

    override fun update(o: Observable?, arg: Any?) {
        // changing text of the buttons
        // according to updated values
        mBinding.btn1.text = "Count: " + myModel!!.getValueAtIndex(0)
        mBinding.btn2.text = "Count: " + myModel!!.getValueAtIndex(1)
        mBinding.btn3.text = "Count: " + myModel!!.getValueAtIndex(2)
    }
}