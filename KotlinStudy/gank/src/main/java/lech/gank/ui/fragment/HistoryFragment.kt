package lech.gank.ui.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import kotlinx.android.synthetic.main.fragment_history.*
import lech.gank.R
import lech.gank.net.Api
import lech.gank.repository.History
import lech.gank.ui.activity.HistoryDetailActivity
import lech.gank.ui.activity.MainActivity
import lech.gank.utils.dismissProgress
import lech.gank.utils.showProgress
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Android_61 on 2017/6/9.
 * Description
 * Others
 */
class HistoryFragment : Fragment() {

    var mActivity: MainActivity? = null

    companion object {
        fun newInstance(): HistoryFragment {
            return HistoryFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        loadPublishedDate()
    }

    private fun loadPublishedDate() {
        showProgress()
        val api = Api.Factory.create()
        api.getHistory()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { result -> setUpRecyclerView(parseHtml(result.string())) },
                        {},
                        { hideProgress() })

    }

    private fun setUpRecyclerView(data: List<History>) {

        val adapter: HistoryAdapter = HistoryAdapter(R.layout.item_history, data)
        adapter.setOnItemClickListener { adapter, view, position ->
            val history: History = adapter.getItem(position) as History
            start2ActivityDetail(history.date)
        }

        recyclerView.adapter = adapter
    }

    private fun start2ActivityDetail(date: String) {
        val intent: Intent = Intent(mActivity, HistoryDetailActivity::class.java)
        intent.putExtra("date", date)
        mActivity!!.startActivity(intent)
    }

    private fun parseHtml(html: String?): List<History> {
        val doc: Document = Jsoup.parse(html)
        val typo: Elements = doc.getElementsByClass("typo")
        var data: MutableList <History> = arrayListOf()

        var history: History

        typo.select("a").iterator().forEach {
            history = History(it.attr("href").substring(1), it.text())
            data.add(history)
        }

        return data
    }

    private fun hideProgress() {
        mActivity!!.dismissProgress()
    }

    private fun showProgress() {
        mActivity!!.showProgress()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(mActivity)
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        this.mActivity = activity as MainActivity?
    }

    override fun onDetach() {
        super.onDetach()
        mActivity = null
    }

    class HistoryAdapter(layoutId: Int, data: List<History>) : BaseQuickAdapter<History, BaseViewHolder>(layoutId, data) {
        override fun convert(helper: BaseViewHolder?, item: History?) {
            helper!!.setText(R.id.content, "${item!!.content}(${item!!.date})")
        }

    }
}