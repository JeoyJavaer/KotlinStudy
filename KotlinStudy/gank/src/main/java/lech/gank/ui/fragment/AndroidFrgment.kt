package lech.gank.ui.fragment

import lech.gank.common.Type

/**
 * Created by Android_61 on 2017/6/9.
 * Description
 * Others
 */
class AndroidFrgment :ArticleFragment(){

    companion object{
        fun newInstance():AndroidFrgment {
            return AndroidFrgment()
        }
    }

    override fun getType(): String {
        return Type.Android.name
    }
}