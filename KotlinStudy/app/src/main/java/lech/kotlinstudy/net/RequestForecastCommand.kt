package lech.weatherapp.net

import lech.weatherapp.domain.Command
import lech.weatherapp.domain.ForecastDataMapper
import lech.weatherapp.domain.ForecastList

/**
 * Created by Android_61 on 2017/6/6.
 * Description
 * Others
 */
class RequestForecastCommand(private val zipCode: String):Command<ForecastList>{
    override fun execute(): ForecastList {
        val forecastReuqest=ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastReuqest.execute())

    }


}