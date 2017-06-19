package lech.kotlinstudy.flow

import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import lech.kotlinstudy.App

/**
 * Created by Android_61 on 2017/6/19.
 * Description
 * Others
 */
class Testflow {
    var x: List<String>? = null
    var y = 1

    val view:View =TextView(App.instance)


    fun test() {
        val res = if (x != null && x?.size >= 0) x else null



        when (y) {
            1 -> print("1")
            2 -> print("2")

            else -> {
                print("I  ")
                print("text")
            }
        }


        val result = when (y) {
            0, 1 -> true
            else -> false
        }


        when(view){
            is  TextView ->view.text="textview"
            is EditText ->  toast("")


        }


        for (item in collection) {
            print(item)
        }

        for (index in 0..10) {
            print(index)
        }
    }

}