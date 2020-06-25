package pl.slyberry.domain

data class Forecast(
  val city: City,
  val values: List<DailyWeather>
)

data class City(val value: String)

data class DailyWeather(
  val date: String,
  val avgTemp: KelvinTemp,
  val minTemp: KelvinTemp,
  val maxTemp: KelvinTemp,
  val pressure: Pressure,
  val humidity: Humidity
)

data class Pressure(val value: Float)

data class Humidity(val value: Int)

data class KelvinTemp(val value: Float) {

  fun celsiusValue() = value - 273.15f
}
