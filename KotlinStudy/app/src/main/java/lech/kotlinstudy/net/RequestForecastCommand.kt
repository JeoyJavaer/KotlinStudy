package lech.weatherapp.net

import lech.kotlinstudy.domain.Command
import lech.kotlinstudy.domain.ForecastDataMapper
import lech.kotlinstudy.domain.ForecastList

/**
 * Created by Android_61 on 2017/6/6.
 * Description
 * Others
 */
class RequestForecastCommand(private val zipCode: String): Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastReuqest=ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastReuqest.execute())

    }


}