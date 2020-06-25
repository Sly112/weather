package pl.slyberry.preview.viewmodel

import pl.slyberry.common.Label
import pl.slyberry.domain.DailyWeather
import pl.slyberry.domain.Forecast
import pl.slyberry.preview.R
import pl.slyberry.preview.view.SuccessViewEntity
import pl.slyberry.preview.view.WeatherItemViewEntity

fun Forecast.toViewEntity(): SuccessViewEntity {
  return SuccessViewEntity(values.map { it.toViewEntity() })
}

fun DailyWeather.toViewEntity(): WeatherItemViewEntity {
  return WeatherItemViewEntity(
    Label.create(date),
    Label.create(R.string.temp, avgTemp.celsiusValue().toString()),
    Label.create(R.string.humidity, humidity.value.toString()),
    Label.create(R.string.pressure, pressure.value.toString())
  )
}
