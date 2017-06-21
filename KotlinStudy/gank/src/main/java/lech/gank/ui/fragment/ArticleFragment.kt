package lech.gank.ui.fragment

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import kotlinx.android.synthetic.main.fragment_base.*
import lech.gank.R
import lech.gank.base.BaseFragment
import lech.gank.repository.Article
import lech.gank.ui.activity.ArticleDetailActivity
import lech.gank.ui.adapter.ArticleAdapter
import org.jetbrains.anko.toast

/**
 * Created by Android_61 on 2017/6/9.
 * Description
 * Others
 */
open abstract class ArticleFragment : BaseFragment() {
    var adapter: ArticleAdapter? = null


    override fun loadError() {
        mActivity!!.toast(R.string.load_failed)
    }

    override fun loadFinish() {
        resetStatus()
    }

    private fun resetStatus() {
        if (swipeLayout!!.isRefreshing) {
            swipeLayout!!.isRefreshing=false
        }
        adapter!!.loadMoreComplete()

    }


    override fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = ArticleAdapter(activity!!.applicationContext, R.layout.item_article)
        adapter!!.setOnLoadMoreListener({ loadMore() }, recyclerView)
        adapter!!.onItemClickListener = BaseQuickAdapter.OnItemClickListener {
            adapter, view, position
            ->
            start2Detail(adapter.data[position]as Article)
        }


    }

    fun start2Detail(article: Article) {
        val intent = Intent(activity, ArticleDetailActivity::class.java)
        intent.putExtra("desc", article.desc)
        intent.putExtra("url", article.url)
        startActivity(intent)
    }

    private fun loadMore() {
        pageNumber++
        isRefresh = false
        loadData(pageSize, pageNumber)


    }

    override fun loadSuccess(data: List<Article>) {
       setUp(data)
    }

    private fun setUp(data: List<Article>) {
        if (isRefresh) {
            adapter!!.setNewData(data)
        } else {
            adapter!!.addData(data)
        }

    }
}