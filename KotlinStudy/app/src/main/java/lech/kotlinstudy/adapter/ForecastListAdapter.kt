package lech.weatherapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import lech.weatherapp.R
import lech.weatherapp.domain.Forecast
import lech.weatherapp.domain.ForecastList
import lech.weatherapp.extension.ctx
import org.jetbrains.anko.find
/**
 * Created by Android_61 on 2017/6/6.
 * Description
 * Others
 */

class ForecastListAdapter(val weakForecast:ForecastList,val itemClick:(Forecast)->Unit):RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){
    override fun getItemCount(): Int=weakForecast.size()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weakForecast[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)

    }


    class ViewHolder(view: View,val itemClick:(Forecast)->Unit) : RecyclerView.ViewHolder(view){
        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)
        }

        fun bindForecast(forecast: lech.weatherapp.domain.Forecast){
            with(forecast){
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high.toString()}"
                minTemperatureView.text = "${low.toString()}"
                itemView.setOnClickListener { itemClick(forecast) }

            }
        }
    }


    public interface onItemClickListener{
        operator fun invoke(forecast: lech.weatherapp.domain.Forecast)
    }
}