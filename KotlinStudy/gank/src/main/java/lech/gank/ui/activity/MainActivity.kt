package lech.gank.ui.activity

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import lech.gank.R
import lech.gank.ui.fragment.ArticleContainerFragment
import lech.gank.ui.fragment.HistoryFragment
import lech.gank.ui.fragment.WelfareFragment

class MainActivity : AppCompatActivity() {
    var lastIndex = -1
    var lastFragment: Fragment? = null
    var articleContainerFragment: ArticleContainerFragment? = null
    var historyFragment: HistoryFragment? = null
    var girlFragment: WelfareFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeTab(0)
    }

    fun changeTab(position: Int) {
        if (lastIndex == position) return

        lastIndex = position
        val fragmentManager = fragmentManager
        val ft = fragmentManager.beginTransaction()
        if (lastFragment != null) {
            ft.hide(lastFragment)
        }

        when (position) {
            0 -> {
                articleContainerFragment = fragmentManager.findFragmentByTag(ArticleContainerFragment::class.java.simpleName) as ArticleContainerFragment?
                if (articleContainerFragment == null) {
                    articleContainerFragment = ArticleContainerFragment.newInstance()
                } else {

                }
            }

            1 -> {

            }

            2 -> {

            }


        }

//        ft.commit()
        ft.commitAllowingStateLoss()
    }
}
