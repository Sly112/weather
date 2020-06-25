package pl.slyberry.domain

import org.threeten.bp.OffsetDateTime

data class Forecast(
  val city: City,
  val values: List<DailyWeather>
)

data class City(val value: String)

data class DailyWeather(
  val date: OffsetDateTime,
  val avgTemp: CelsiusTemp,
  val minTemp: CelsiusTemp,
  val maxTemp: CelsiusTemp,
  val pressure: Pressure,
  val humidity: Humidity
)

data class Pressure(val value: Float)
data class Humidity(val value: Int)
data class CelsiusTemp(val value: Float)
