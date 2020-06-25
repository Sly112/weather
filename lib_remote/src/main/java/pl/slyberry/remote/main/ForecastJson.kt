package pl.slyberry.remote.main

import com.squareup.moshi.Json

data class ForecastJson(
  @field:Json(name = "city")
  val city: CityJson,

  @field:Json(name = "list")
  val weatherList: List<DailyWeatherJson>
)

data class CityJson(
  @field:Json(name = "name")
  val name: String
)

data class DailyWeatherJson(
  @field:Json(name = "dt_txt")
  val date: String,

  @field:Json(name = "main")
  val main: MainJson
)

data class MainJson(
  @field:Json(name = "temp")
  val day: Float,

  @field:Json(name = "temp_min")
  val min: Float,

  @field:Json(name = "pressure")
  val pressure: Float,

  @field:Json(name = "temp_max")
  val max: Float,

  @field:Json(name = "humidity")
  val humidity: Int
)
