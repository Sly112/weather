package pl.slyberry.remote.main

import org.threeten.bp.ZoneId
import pl.slyberry.domain.*
import pl.slyberry.domain.City

private val ZONE_ID = ZoneId.of("UTC")

fun ForecastJson.toDomain(): Forecast {
  return Forecast(
    City(city.name),
    weatherList.map {
      DailyWeather(
        it.date,
        KelvinTemp(it.main.day),
        KelvinTemp(it.main.min),
        KelvinTemp(it.main.max),
        Pressure(it.main.pressure),
        Humidity(it.main.humidity)
      )
    }
  )
}
