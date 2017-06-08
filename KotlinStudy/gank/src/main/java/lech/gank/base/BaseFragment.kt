package lech.gamk.base

import android.app.Activity
import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient.FileChooserParams.parseResult
import lech.gamk.R
import kotlinx.android.synthetic.main.fragment_article_list.*
import lech.gamk.net.Api
import lech.gamk.repository.Article
import lech.gamk.repository.Result
import rx.Scheduler
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Android_61 on 2017/6/8.
 * Description
 * Others
 */
abstract class BaseFragment : Fragment() {

    val TAG = BaseFragment::class.java.simpleName
    var pageSize = 10
    var pageNumber = 1
    var isRfresh = false
    var activity: Activity? = null
    var rootView: View? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        if (rootView == null) {
            rootView = inflater!!.inflate(R.layout.fragment_base, container, false)
        }

        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()

        swipeLayout.setOnRefreshListener {
            pageNumber = 1
            isRfresh = true
            loadData(pageSize, pageNumber)
        }

        loadData(pageSize, pageNumber)
    }

    protected fun loadData(pageSize: Int, pageNumber: Int) {
        val api = Api.Factory.create()
        api.getData(getType(), pageSize, pageNumber)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { result -> parseResult(result) },
                        {
                            loadError()
                            loadFinish()
                        }
                )
    }

    fun parseResult(result: Result) {
        if (result.error) {
            loadError()
        } else {
            loadSuccess(result.results)
        }
        loadFinish()
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        this.activity = activity
    }


    override fun onDetach() {
        super.onDetach()
        this.activity = null
    }

    abstract fun loadSuccess(data: List<Article>)

    abstract fun loadError()

    abstract fun loadFinish()

    abstract fun getType(): String

    abstract fun initRecyclerView()


}