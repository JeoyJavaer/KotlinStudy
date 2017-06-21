package lech.gank.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.SimpleItemAnimator
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import kotlinx.android.synthetic.main.fragment_base.*
import lech.gank.R
import lech.gank.base.BaseFragment
import lech.gank.common.Type
import lech.gank.repository.Article
import lech.gank.ui.activity.PhotoActivity
import org.jetbrains.anko.toast

/**
 * Created by Android_61 on 2017/6/9.
 * Description
 * Others
 */
class WelfareFragment : BaseFragment() {
    var adapter: GirlAdapter? = null

    companion object {
        fun newInstance(): WelfareFragment {
            return WelfareFragment()
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.visibility = View.VISIBLE
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

    override fun loadError() {
        mActivity!!.toast(R.string.load_failed)
    }

    override fun loadFinish() {
        if (swipeLayout!!.isRefreshing) {
            swipeLayout!!.isRefreshing = false
        }
        adapter!!.loadMoreComplete()
    }

    override fun getType(): String {
        return Type.福利.name
    }

    override fun initRecyclerView() {
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val simpleAnimator: SimpleItemAnimator = recyclerView.itemAnimator as SimpleItemAnimator
        simpleAnimator.supportsChangeAnimations = false

        adapter = GirlAdapter(mActivity!!.applicationContext, R.layout.item_girl)
        adapter!!.onItemClickListener = BaseQuickAdapter.OnItemClickListener {
            adapter, view, position ->
            start2PhotoActivity(adapter.getItem(position) as Article)
        }

        recyclerView.adapter = adapter
        adapter!!.setOnLoadMoreListener({
            pageNumber++
            isRefresh = false
            loadData(pageSize, pageNumber)
        }, recyclerView)

    }

    private fun start2PhotoActivity(article: Article) {
        val intent = Intent(activity, PhotoActivity::class.java)
        intent.putExtra("url", article.url)
        activity!!.startActivity(intent)

    }


    class GirlAdapter(val context: Context, layoutId: Int) : BaseQuickAdapter<Article, BaseViewHolder>(layoutId) {
        override fun convert(helper: BaseViewHolder?, item: Article?) {
            val imageView = helper!!.getView<ImageView>(R.id.image)
            Glide.with(context).load(item!!.url).into(imageView)
        }

    }
}