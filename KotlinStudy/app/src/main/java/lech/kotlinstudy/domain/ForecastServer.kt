package lech.kotlinstudy.domain

import lech.kotlinstudy.db.ForecastDb

/**
 * Created by Android_61 on 2017/6/19.
 * Description
 * Others
 */
class ForecastServerval(dataMapper: ServerDataMapper = ServerDataMapper(), val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {
    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)

    }


}