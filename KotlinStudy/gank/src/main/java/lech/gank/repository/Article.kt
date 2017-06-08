package lech.gamk.repository

/**
 * Created by Android_61 on 2017/6/8.
 * Description
 * Others
 */
data  class Article(val _id:String,val createdAt:String,val desc:String,
                    var image:Array<String>,val publishdAt:String,
                    val source:String,val type:String,val url:String,
                    val used:Boolean,val who:String
                    )