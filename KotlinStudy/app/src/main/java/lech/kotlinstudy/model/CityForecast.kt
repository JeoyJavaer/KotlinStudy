package lech.kotlinstudy.model

/**
 * Created by Android_61 on 2017/6/16.
 * Description
 * Others
 */
class CityForecast(val map: MutableMap<String, Any?>, val dailyForecast: List<DayForecast>) {
    var _id: Long  by map
    var city: String by map
    var country: String by map

    constructor(id: Long, city: String, dailyForecast: List<DayForecast>) : this(HashMap(), dailyForecast) {
        this._id = id
        this.city = city
        this.country = country
    }

}