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
  @field:Json(name = "dt")
  val date: Long,

  @field:Json(name = "temp")
  val temp: TempJson,

  @field:Json(name = "pressure")
  val pressure: Float,

  @field:Json(name = "humidity")
  val humidity: Int
)

data class TempJson(
  @field:Json(name = "day")
  val day: Float,

  @field:Json(name = "min")
  val min: Float,

  @field:Json(name = "max")
  val max: Float
)
