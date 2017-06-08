package lech.kotlinstudy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import lech.kotlinstudy.R
import lech.weatherapp.adapter.ForecastListAdapter
import lech.weatherapp.net.RequestForecastCommand
import org.jetbrains.anko.async
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        kotlinx.android.synthetic.main.activity_main.forecastList.layoutManager = LinearLayoutManager(this)

        async {
            val result = RequestForecastCommand("94043").execute()
            runOnUiThread {
                //                val  adapter=ForecastListAdapter(result){forecast -> toast(forecast.date) }
                val adapter = ForecastListAdapter(result) { toast(it.date) }
                kotlinx.android.synthetic.main.activity_main.forecastList.adapter = adapter
            }
        }

    }


}
