package pl.slyberry.preview.view

import android.view.ViewGroup
import kotlinx.android.synthetic.main.weather_item_layout.view.*
import pl.slyberry.common.Label
import pl.slyberry.common.setLabel
import pl.slyberry.preview.R

class WeatherItemViewHolder(parent: ViewGroup) : SimpleRecyclerViewHolder(R.layout.weather_item_layout, parent) {

  fun applyViewEntity(viewEntity: WeatherItemViewEntity) {
    with (itemView) {
      date.setLabel(viewEntity.date)
      temp.setLabel(viewEntity.temp)
      humidity.setLabel(viewEntity.humidity)
      pressure.setLabel(viewEntity.pressure)
    }
  }
}

data class WeatherItemViewEntity(val date: Label, val temp: Label, val humidity: Label, val pressure: Label)
