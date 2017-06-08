package lech.weatherapp.tst

import kotlin.properties.Delegates


/**
 * Created by Android_61 on 2017/6/8.
 * Description
 * Others
 */
class Example {
    var p : String by Delegates.notNull<String>()

}
