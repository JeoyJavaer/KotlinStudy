package lech.kotlinstudy.domain

import lech.kotlinstudy.db.ForecastDb

/**
 * Created by Android_61 on 2017/6/19.
 * Description
 * Others
 */
class ForecastProvider(val source:List<ForecastDataSource> = ForecastProvider.SOURCES){


    companion object{
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
        val SOURCES= listOf(ForecastDb(),ForecastServer())
    }


    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = source.firstResult { requestSource(it, days, zipCode) }

    private fun requestSource(source: RepositorySource, days: Int,zipCode: Long): ForecastList? {
        val res = source.requestForecastByZipCode(zipCode, todayTimeSpan())
        return if (res != null && res.size() >= days) res else null
    }

    private fun todayTimeSpan() = System.currentTimeMillis() /
            DAY_IN_MILLIS * DAY_IN_MILLIS

}