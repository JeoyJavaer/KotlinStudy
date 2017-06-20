package lech.kotlinstudy.apply

import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import lech.kotlinstudy.App
import lech.kotlinstudy.R
import lech.kotlinstudy.extension.ctx
import lech.kotlinstudy.extension.slideEnter
import lech.kotlinstudy.extension.slideExit
import org.jetbrains.anko.toast

/**
 * Created by Android_61 on 2017/6/20.
 * Description
 * Others
 */
interface ToolbarManager {
    val toolbar: Toolbar

    var toobarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }

    fun  initToolbar(){
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_setting ->  App.instance.toast("Settings")

                else -> App.instance.toast("others")
            }
            true
        }
    }

    fun  enableHomeAsUp(up:()->Unit){
        toolbar.navigationIcon=createUpDrawable()
        toolbar.setNavigationOnClickListener { up() }
    }

    private fun createUpDrawable()= with(DrawerArrowDrawable(toolbar.ctx)){
        progress=1f
        this
    }


    fun  attachToScroll(recycleView:RecyclerView){
        recycleView.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy>0) toolbar.slideExit() else toolbar.slideEnter()

            }
        })
    }

}