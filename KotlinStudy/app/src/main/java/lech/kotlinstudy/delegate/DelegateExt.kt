package lech.kotlinstudy.delegate

import android.content.Context
import lech.kotlinstudy.App
import java.lang.IllegalArgumentException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Android_61 on 2017/6/14.
 * Description
 * Others
 */
public object DelegateExt {

    fun <T : Any> notNullSingleValue():
            ReadWriteProperty<Any?, T> = NotNullSingleValueVar()


    fun longPreference(context: Context, name: String, default: Long) = LongPreference(context, name, default)


    fun <T :Any> preference(context: Context, name: String, default: T) = MyPreference(context, name, default)

}


class LongPreference(val context: Context, val name: String, val default: Long) : ReadWriteProperty<Any?, Long> {
    val prefs by lazy { context.getSharedPreferences("default", Context.MODE_PRIVATE) }

    override fun getValue(thisRef: Any?, property: KProperty<*>): Long {
        return prefs.getLong(name, default)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
        prefs.edit().putLong(name, value).apply()
    }
}

class MyPreference<T>(val context: Context = App.instance, val name: String, val default: T) : ReadWriteProperty<Any, T> {

    val prefs by lazy {
        context.getSharedPreferences("default", Context.MODE_PRIVATE)
    }


    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return findPreference(name, default)
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        putPreference(name, value)
    }

    private fun <U> putPreference(name: String, value: U) = with(prefs.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> throw  IllegalArgumentException("type error")

        }.apply()
    }


    private fun <T> findPreference(name: String, default: T): T = with(prefs) {

        val res: Any = when (default) {
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            else -> throw  IllegalArgumentException("type error")
        }

        res as T

    }

}
