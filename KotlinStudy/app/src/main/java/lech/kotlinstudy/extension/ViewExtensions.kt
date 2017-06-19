package lech.kotlinstudy.extension

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.view.View

/**
 * Created by Android_61 on 2017/6/6.
 * Description
 * Others
 */

val View.ctx: Context
    get() = context


fun SQLiteDatabase.clear(tableName: String) {
    execSQL("delect from $tableName")
}


//fun <K, V : Any> MutableMap<K, V?>.toVarargArray(): Array<out Pair<K, V>>=map({ Pair(it.key, it.value!!) }).toTypedArray()
