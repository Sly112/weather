package pl.slyberry.preview

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.slyberry.preview.viewmodel.WeatherForecastViewModel

val weatherForecastModule = module {
  viewModel { WeatherForecastViewModel(get()) }
}
