package lech.gank.ui.fragment

import lech.gank.common.Type

/**
 * Created by Android_61 on 2017/6/9.
 * Description
 * Others
 */
class WebFragment :ArticleFragment(){


    companion object{
        fun  newInstance():WebFragment{
            return WebFragment()
        }
    }

    override fun getType(): String {
        return Type.前端.name
    }


}