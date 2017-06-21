package lech.gank.ui.fragment

import lech.gank.common.Type

/**
 * Created by Android_61 on 2017/6/9.
 * Description
 * Others
 */
class ExpandFragment : ArticleFragment() {
    companion object {
        fun newInstance(): ExpandFragment {
            return ExpandFragment()
        }
    }

    override fun getType(): String {
        return Type.拓展资源.name
    }
}