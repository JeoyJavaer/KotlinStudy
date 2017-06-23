package lech.kotlinstudy.db

import lech.kotlinstudy.domain.Forecast
import lech.kotlinstudy.domain.ForecastList
import lech.kotlinstudy.model.CityForecast
import lech.kotlinstudy.model.DayForecast

/**
 * Created by Android_61 on 2017/6/19.
 * Description
 * Others
 */
class DataMapper {

    fun convertFromDomain(forecast: ForecastList) = with(forecast) {
        val daily = dailyForecast.map { convertDayFromDomain(id, it) }
        CityForecast(id, city, country, daily)
    }

    private fun convertDayFromDomain(cityId: Long, forecast: Forecast) = with(forecast) {
        DayForecast(date, description, high, low, iconUrl, cityId)
    }

    fun convertToDomain(forecast: CityForecast) = with(forecast) {
        val daily = dailyForecast.map { convertDayToDomain(it) }
        ForecastList(_id, city, country, daily)
    }

    fun convertDayToDomain(dayForecast: DayForecast) = with(dayForecast) {
        Forecast(_id, date, description, high, low, iconUrl)
    }
}