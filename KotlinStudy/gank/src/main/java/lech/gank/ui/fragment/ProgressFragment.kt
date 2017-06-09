package lech.gank.ui.fragment

import android.app.DialogFragment
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar

/**
 * Created by Android_61 on 2017/6/9.
 * Description
 * Others
 */
class ProgressFragment : DialogFragment() {
    companion object{

        fun newInstance():ProgressFragment{
            return  ProgressFragment()
        }

    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return ProgressBar(activity)
    }

}