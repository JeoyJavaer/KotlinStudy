package lech.kotlinstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import lech.kotlinstudy.apply.ToolbarManager
import lech.kotlinstudy.delegate.DelegateExt

class ToolbarTestActivity : AppCompatActivity(), ToolbarManager {
    companion object {

        val ZIP_CODE = "zipCode"
        val DEFAULT_ZIP = 9403L

    }


    var zipCode:Long by DelegateExt.longPreference(this, ZIP_CODE, DEFAULT_ZIP)

    override val toolbar: Toolbar
        get() = TODO("not implemented")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar_test)
        initToolbar()
        toolbar.title = "Toolbar"

        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)
        enableHomeAsUp { onBackPressed() }

        val toString = zipCode.toString()
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item!!.itemId) {
        android.R.id.home -> {
            onBackPressed(); true
        }
        else -> false
    }


    override fun onBackPressed() {
        super.onBackPressed()

    }

}


