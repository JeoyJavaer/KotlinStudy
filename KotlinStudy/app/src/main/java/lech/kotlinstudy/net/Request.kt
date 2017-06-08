package lech.weatherapp.net

import android.util.Log
import java.net.URL

/**
 * Created by Android_61 on 2017/6/6.
 * Description
 * Others
 */
public  class Request(val url:String){

    public  fun run(){
        val forecastJsonStr=URL(url).readText()
        Log.d(javaClass.simpleName,forecastJsonStr)
    }

}