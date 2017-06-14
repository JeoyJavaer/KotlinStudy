package lech.kotlinstudy.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by Android_61 on 2017/6/14.
 * Description
 * Others
 */
 abstract class ManagerSQLiteOpenHelper(context: Context, name:String, factory : SQLiteDatabase.CursorFactory?, version:Int):SQLiteOpenHelper(context,name,factory,version) {

}