package lech.gank.ui.fragment

import lech.gank.common.Type

/**
 * Created by Android_61 on 2017/6/9.
 * Description
 * Others
 */
class IOSFragment :ArticleFragment(){
    companion object{
        fun newInstance():IOSFragment {
            return IOSFragment()
        }
    }

    override fun getType(): String {
        return Type.iOS.name
    }

}