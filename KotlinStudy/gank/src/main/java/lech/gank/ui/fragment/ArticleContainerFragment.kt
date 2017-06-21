package lech.gank.ui.fragment

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.design.widget.TabLayout.MODE_SCROLLABLE
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_article_container.*
import lech.gank.R
import lech.gank.net.Api
import lech.gank.repository.PublishedDate
import lech.gank.ui.activity.MainActivity
import lech.gank.ui.adapter.MainAdapter
import lech.gank.utils.dismissProgress
import lech.gank.utils.showProgress
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Android_61 on 2017/6/9.
 * Description
 * Others
 */
class ArticleContainerFragment : Fragment() {

    var published: String? = null
    var activity: MainActivity? = null

    companion object {
        fun newInstance(): ArticleContainerFragment {
            return ArticleContainerFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_article_container, container, false)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadPublishedDate()
    }

    private fun loadPublishedDate() {
        showProgress()
        val api = Api.Factory.create()
        api.getPublishedDate()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    result ->
                    parseResult(result)
                },
                        {},
                        { onComplete() }
                )

    }

    private fun parseResult(result: PublishedDate) {
        if (result.error || result.results == null || result.results.size == 0) {
            published = getCurrentDate()
            return
        }

        published = result.results[0].replace("-", "/")
    }

    private fun getCurrentDate(): String? {
        val sdf = SimpleDateFormat("yyyy/MM/dd")
        return sdf.format(Date())
    }

    private fun onComplete() {
        dismissProgress()
        setUpView()
    }

    private fun setUpView() {
        val fragments = arrayListOf<Fragment>()
        fragments.add(RecommendFragment.newInstance(published!!))
        fragments.add(AndroidFrgment.newInstance())
        fragments.add(IOSFragment.newInstance())
        fragments.add(WebFragment.newInstance())
        fragments.add(VideoFragment.newInstance())
        fragments.add(ExpandFragment.newInstance())

        val titles = resources.getStringArray(R.array.title)
        viewPager.adapter = MainAdapter(fragments, titles, childFragmentManager)
        viewPager.offscreenPageLimit = 6

        tabLayout.setupWithViewPager(viewPager)
        tabLayout.tabMode = MODE_SCROLLABLE

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.setCurrentItem(tab!!.position, false)
            }

        })

    }

    private fun showProgress() {
        if (activity != null) {
            activity!!.showProgress()
        }

    }

    private fun dismissProgress() {
        if (activity != null) {
            activity!!.dismissProgress()
        }
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        this.activity = activity as MainActivity?

    }

    override fun onDetach() {
        super.onDetach()
        activity = null
    }


}