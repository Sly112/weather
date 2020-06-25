package pl.slyberry.preview.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WeatherForecastAdapter : RecyclerView.Adapter<SimpleRecyclerViewHolder>() {

  var items = emptyList<WeatherItemViewEntity>()
    set(value) {
      field = value
      notifyDataSetChanged()
    }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleRecyclerViewHolder {
    return WeatherItemViewHolder(parent)
  }

  override fun getItemCount() = items.size

  override fun onBindViewHolder(holder: SimpleRecyclerViewHolder, position: Int) {
    (holder as WeatherItemViewHolder).applyViewEntity(items[position])
  }
}
