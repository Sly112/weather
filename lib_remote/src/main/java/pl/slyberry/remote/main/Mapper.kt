package pl.slyberry.remote.main

import org.threeten.bp.Instant
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.ZoneId
import pl.slyberry.domain.*
import pl.slyberry.domain.City

private val ZONE_ID = ZoneId.of("UTC")

fun ForecastJson.toDomain(): Forecast {
  return Forecast(
    City(city.name),
    weatherList.map {
      DailyWeather(
        OffsetDateTime.ofInstant(Instant.ofEpochMilli(it.date), ZONE_ID),
        CelsiusTemp(it.temp.day),
        CelsiusTemp(it.temp.min),
        CelsiusTemp(it.temp.max),
        Pressure(it.pressure),
        Humidity(it.humidity)
      )
    }
  )
}
