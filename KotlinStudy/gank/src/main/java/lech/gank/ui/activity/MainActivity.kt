package lech.gank.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
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
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_recommend -> changeTab(0)
                R.id.action_girl -> changeTab(1)
                R.id.action_history -> changeTab(2)
            }
            true
        }
        changeTab(0)
    }

    fun changeTab(position: Int) {
        if (lastIndex == position) return

        lastIndex = position
        val fragmentManager = supportFragmentManager
        val ft = fragmentManager.beginTransaction()
        if (lastFragment != null) {
            ft.hide(lastFragment)
        }

        when (position) {
            0 -> {
                articleContainerFragment = fragmentManager.findFragmentByTag(ArticleContainerFragment::class.java.simpleName) as ArticleContainerFragment?
                if (articleContainerFragment == null) {
                    articleContainerFragment = ArticleContainerFragment.newInstance()
                    ft.add(R.id.container,articleContainerFragment,ArticleContainerFragment::class.java.simpleName)
                } else {
                    ft.show(articleContainerFragment)
                }
                lastFragment=articleContainerFragment
            }

            1 -> {
                girlFragment = fragmentManager.findFragmentByTag(WelfareFragment::class.java.simpleName) as WelfareFragment?

                if (girlFragment == null) {
                    girlFragment = WelfareFragment.newInstance()
                    ft.add(R.id.container,girlFragment,WelfareFragment::class.java.simpleName)
                }else{
                    ft.show(girlFragment)
                }

                lastFragment = girlFragment
            }

            2 -> {
                historyFragment = fragmentManager.findFragmentByTag(HistoryFragment::class.java.simpleName) as HistoryFragment?

                if (historyFragment == null) {
                    historyFragment = HistoryFragment.newInstance()
                    ft.add(R.id.container,historyFragment,HistoryFragment::class.java.simpleName)
                }else{
                    ft.show(historyFragment)
                }

                lastFragment = historyFragment
            }


        }

//        ft.commit()
        ft.commitAllowingStateLoss()
    }
}
