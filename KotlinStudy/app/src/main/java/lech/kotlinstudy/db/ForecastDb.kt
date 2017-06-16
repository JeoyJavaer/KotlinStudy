package lech.kotlinstudy.db

import lech.kotlinstudy.R.id.date
import lech.kotlinstudy.model.DayForecast

/**
 * Created by Android_61 on 2017/6/16.
 * Description
 * Others
 */
class ForecastDb(
    val forecastDbHelper:ForecastDbHelper=ForecastDbHelper.instance,
    val dateManager :DbDataMapper=DbDataMapper()){



    fun requestForecastByZipCode(zipCode:Long,date:Long)=forecastDbHelper.use{ }

    val dailyRequest="${DayForecastTable.CITY_ID}=?"+"AND ${DayForecastTable.DATE} >=?"

    val dailyForecast=select(DayForecastTable.NAME).whereSimle(dailyRequest,ZipCode.toString(),date.toString()).parseList{DayForecast(HashMap(it))}




}