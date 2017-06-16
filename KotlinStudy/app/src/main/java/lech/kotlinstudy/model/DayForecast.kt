package lech.kotlinstudy.model

/**
 * Created by Android_61 on 2017/6/16.
 * Description
 * Others
 */
class DayForecast(var map:MutableMap<String,Any?>) {
    var _id:Long by map
    var  date:String by map
    var description by map
    var high:Int by map
    var low:Int by map
    var iconUrl:String by map
    var cityId:Long by map


    constructor(date:String,description:String,high:Int,low:Int,iconUrl:String,cityId:Long):this(HashMap()){
        this.date=date
        this.description=description
        this.high=high
        this.low=low
        this.iconUrl=iconUrl
        this.cityId=cityId
    }


}