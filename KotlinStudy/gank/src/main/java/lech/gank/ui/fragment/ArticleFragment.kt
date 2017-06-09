package lech.gank.ui.fragment

import lech.gank.base.BaseFragment
import lech.gank.repository.Article

/**
 * Created by Android_61 on 2017/6/9.
 * Description
 * Others
 */
open class ArticleFragment :BaseFragment(){
    override fun loadError() {
    }

    override fun loadFinish() {
    }

    override fun getType(): String {
        return ""
    }

    override fun initRecyclerView() {
    }

    override fun loadSuccess(data: List<Article>) {

    }
}