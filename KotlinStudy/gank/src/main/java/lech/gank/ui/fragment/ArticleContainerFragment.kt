package lech.gank.ui.fragment

import android.app.Activity
import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lech.gank.R
import lech.gank.ui.activity.MainActivity
import lech.gank.net.Api
import lech.gank.repository.PublishedDate
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
        api.getPublishedDAte()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
//                .subscribe(
//                        {
//                            result ->parseResult(result)
//                        }
//
//                        {}
//                        { onComplete() }
//                )

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
        val fragmetns = arrayListOf<Fragment>()
        fragmetns.add(RecommendFragment.newInstance(published!!))
        fragmetns.add(AndroidFrgment.newInstance())
        fragmetns.add(IOSFragment.newInstance())
        fragmetns.add(WebFragment.newInstance())
        fragmetns.add(VideoFragment.newInstance())
        fragmetns.add(ExpandFragment.newInstance())

        val titles=resources.getString(R.array.title)



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