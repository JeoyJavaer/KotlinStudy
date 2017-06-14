package lech.kotlinstudy.delegate

import kotlin.properties.ReadWriteProperty

/**
 * Created by Android_61 on 2017/6/14.
 * Description
 * Others
 */
public object DelegateExt{

    fun  <T: Any>notNullSingleValue():
            ReadWriteProperty<Any?,T> = NotNullSingleValueVar()

}