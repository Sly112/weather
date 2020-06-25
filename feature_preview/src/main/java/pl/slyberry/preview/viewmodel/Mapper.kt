package pl.slyberry.preview.viewmodel

import pl.slyberry.domain.DailyWeather
import pl.slyberry.domain.Forecast
import pl.slyberry.preview.view.SuccessViewEntity
import pl.slyberry.preview.view.WeatherItemViewEntity

fun Forecast.toViewEntity(): SuccessViewEntity {
  return SuccessViewEntity(values.map { it.toViewEntity() })
}

fun DailyWeather.toViewEntity(): WeatherItemViewEntity {
  return WeatherItemViewEntity(avgTemp.value.toString())
}
