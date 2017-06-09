package lech.gank.ui.fragment

import android.app.Fragment
import android.os.Bundle

/**
 * Created by Android_61 on 2017/6/9.
 * Description
 * Others
 */
class RecommendFragment :Fragment(){

    companion object{
        fun  newInstance(date:String):RecommendFragment{
            val  fragment:RecommendFragment= RecommendFragment()
            val  args:Bundle= Bundle()
            if (!date.isEmpty()) {
                args.putString("data",date)
            }

            fragment.arguments=args
            return fragment
        }
    }
}