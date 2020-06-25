package pl.slyberry.preview.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.weather_forecast_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel
import pl.slyberry.common.exhaustive
import pl.slyberry.common.inflateNoAttach
import pl.slyberry.common.makeGone
import pl.slyberry.common.makeVisible
import pl.slyberry.preview.R
import pl.slyberry.preview.viewmodel.WeatherForecastViewModel

class WeatherForecastFragment : Fragment() {

  private val viewModel by viewModel<WeatherForecastViewModel>()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflateNoAttach(R.layout.weather_forecast_fragment, container)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val adapter = WeatherForecastAdapter()
    recycler_view.adapter = adapter

    viewModel.viewEntity.observe(viewLifecycleOwner, Observer {
      when (it) {
        LoadingViewEntity -> applyLoadingViewEntity(adapter)
        is SuccessViewEntity -> applySuccessViewEntity(it, adapter)
        ErrorViewEntity -> applyErrorViewEntity()
      }.exhaustive
    })

    refresh_button.setOnClickListener { queryForecast() }

    refresh_layout.setOnRefreshListener { queryForecast() }
  }

  private fun queryForecast() {
    viewModel.query(input_text.text.toString())
  }

  private fun applyLoadingViewEntity(adapter: WeatherForecastAdapter) {
    progress_bar.makeVisible()
    input_text_layout.error = null
    adapter.items = emptyList()
  }

  private fun applySuccessViewEntity(viewEntity: SuccessViewEntity, adapter: WeatherForecastAdapter) {
    progress_bar.makeGone()
    input_text_layout.error = null
    adapter.items = viewEntity.items
    refresh_layout.isRefreshing = false
  }

  private fun applyErrorViewEntity() {
    progress_bar.makeGone()
    input_text_layout.error = getString(R.string.no_data_error)
    refresh_layout.isRefreshing = false
  }
}
