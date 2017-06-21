package lech.gank.ui.adapter

import android.content.Context
import android.text.format.DateUtils
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import lech.gank.R
import lech.gank.repository.Article
import java.text.SimpleDateFormat
/**
 * Created by Android_61 on 2017/6/21.
 * Description
 * Others
 */
class ArticleAdapter(var context: Context, layoutID: Int) : BaseQuickAdapter<Article, BaseViewHolder>(layoutID) {

    val sdf: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

    override fun convert(helper: BaseViewHolder?, item: Article?) {
        helper!!.setText(R.id.title,item!!.desc)
        helper.setText(R.id.who,item!!.who)
        helper.setText(R.id.type,item!!.type)
        helper.setText(R.id.publishedAt, DateUtils.getRelativeTimeSpanString(sdf.parse(item!!.publishedAt).time))

        val image: ImageView = helper.getView(R.id.image)

        if (item!!.images == null || item!!.images.size == 0) {
            image.visibility = View.GONE
        }else{
            image.visibility = View.VISIBLE
            val width:Int = context.resources.getDimension(R.dimen.article_image_width).toInt()
            Glide.with(context).load("${item!!.images[0]}?imageView2/0/w/$width").into(image)
        }

    }
}