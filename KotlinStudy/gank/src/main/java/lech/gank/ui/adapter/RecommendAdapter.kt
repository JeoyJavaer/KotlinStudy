package lech.gank.ui.adapter

import android.text.Html
import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import lech.gank.R
import lech.gank.repository.Article

/**
 * Created by Android_61 on 2017/6/21.
 * Description
 * Others
 */
class RecommendAdapter (layoutId:Int,data:List<Article>):BaseQuickAdapter<Article,BaseViewHolder>(layoutId,data){
    override fun convert(helper: BaseViewHolder?, item: Article?) {
        val  format="<font color='#757575'> ${item!!.who}</font>"
        val desc=helper!!.getView<TextView>(R.id.content)
        desc.text=Html.fromHtml("${item.desc}(${format})")
        val  title=helper.getView<TextView> (R.id.title)
        title.text=item!!.type
        val position = helper.getLayoutPosition() - this.getHeaderLayoutCount()
        when (position) {
            0 -> {
                title.visibility = View.VISIBLE
            }
            else ->{
                if (item.type == getItem((position-1))!!.type) {
                    title.visibility = View.GONE
                }else{
                    title.visibility = View.VISIBLE
                }
            }
        }



    }
}