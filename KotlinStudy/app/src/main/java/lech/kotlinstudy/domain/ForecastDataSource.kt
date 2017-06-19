package lech.kotlinstudy.domain

/**
 * Created by Android_61 on 2017/6/19.
 * Description
 * Others
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(zipcode:Long,date:Long):ForecastList?

}