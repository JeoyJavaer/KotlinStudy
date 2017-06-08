package lech.weatherapp.domain

/**
 * Created by Android_61 on 2017/6/6.
 * Description
 * Others
 */
data class ForecastList(val city: String, val country: String, val dailyForecast: List<lech.weatherapp.domain.Forecast>) {
    operator fun get(position: Int)=dailyForecast[position]
    fun size()=dailyForecast.size
}

data class Forecast(val date:String,val description:String,val high: Int,val low: Int,val iconUrl: String)
