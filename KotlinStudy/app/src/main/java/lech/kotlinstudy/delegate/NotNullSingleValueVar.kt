package lech.kotlinstudy.delegate

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Android_61 on 2017/6/14.
 * Description
 * Others
 */
class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?, T> {



    private var value: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value?: throw  UnsupportedOperationException("not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value=if (this.value==null)value
                    else throw IllegalStateException("already initialized")
    }


}