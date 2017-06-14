package lech.kotlinstudy

import android.app.Application
import lech.kotlinstudy.delegate.DelegateExt
import kotlin.properties.Delegates

/**
 * Created by Android_61 on 2017/6/8.
 * Description
 * Others
 */
class App : Application(){
    companion object{
//        private var instance:Application?=null
//        fun instance()= instance!!
        var instance: App by Delegates.notNull()
        var  newInstance:App by DelegateExt.notNullSingleValue()

    }


//    val database: SQLiteOpenHelper by lazy {
//        MyDatabaseHelper(applicationContext)
//    }

    override fun onCreate() {
        super.onCreate()
        instance =this
        newInstance=this
//        val  db=database.writableDatabase
    }

}