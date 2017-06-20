package lech.gank.utils

import android.support.v7.app.AppCompatActivity
import lech.gank.ui.fragment.ProgressFragment

/**
 * Created by Android_61 on 2017/6/8.
 * Description
 * Others
 */
class Utils {


    fun AppCompatActivity.showProgress() {
        val dialog = ProgressFragment.newInstance()
        dialog.show(fragmentManager, ProgressFragment::class.java.simpleName)
    }

    fun AppCompatActivity.dismissProgress() {
        (fragmentManager.findFragmentByTag(ProgressFragment::class.java.simpleName) as ProgressFragment?)?.dismiss()
    }

    fun String.isEmpty(str: String): Boolean {
        return str == null || str == ""
    }
}