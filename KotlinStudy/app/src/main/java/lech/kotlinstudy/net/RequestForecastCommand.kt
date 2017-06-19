package lech.weatherapp.net

import lech.kotlinstudy.domain.Command
import lech.kotlinstudy.domain.ForecastDataMapper
import lech.kotlinstudy.domain.ForecastList
import lech.kotlinstudy.domain.ForecastProvider

/**
 * Created by Android_61 on 2017/6/6.
 * Description
 * Others
 */
class RequestForecastCommand(private val zipCode: String, val forecastProvider: ForecastProvider = ForecastProvider()) : Command<ForecastList> {
    companion object{
        val DAYS=7
    }

    override fun execute(): ForecastList {

        return ForecastProvider.requestByZipCode(zipCode, DAYS)

    }


}