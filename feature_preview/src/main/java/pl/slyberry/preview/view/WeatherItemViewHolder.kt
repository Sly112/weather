package pl.slyberry.preview.view

import android.view.ViewGroup
import pl.slyberry.preview.R

class WeatherItemViewHolder(parent: ViewGroup) : SimpleRecyclerViewHolder(R.layout.weather_item_layout, parent) {

  fun applyViewEntity(viewEntity: WeatherItemViewEntity) {

  }
}

data class WeatherItemViewEntity(val title: String)
