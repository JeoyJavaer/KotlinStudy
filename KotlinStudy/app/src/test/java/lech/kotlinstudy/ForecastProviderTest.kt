package lech.kotlinstudy

import junit.framework.Assert.assertNotNull
import lech.kotlinstudy.data.Forecast
import lech.kotlinstudy.domain.ForecastDataSource
import lech.kotlinstudy.domain.ForecastProvider
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

/**
 * Created by Android_61 on 2017/6/20.
 * Description
 * Others
 */
class ForecastProviderTest {

    @Test fun testDataSourceReturnsValue() {
        val ds = mock(ForecastDataSource::class.java)
        `when`(ds.requestDayForecast(0)).then {
            Forecast(0, 0, "desc", 20, 0, "url")
        }
        val provider = ForecastProvider(listOf(ds))
        assertNotNull(provider.requestForecast(0))
    }


}