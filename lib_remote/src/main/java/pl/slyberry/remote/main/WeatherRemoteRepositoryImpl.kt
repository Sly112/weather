package pl.slyberry.remote.main

import io.reactivex.Single
import pl.slyberry.domain.City
import pl.slyberry.domain.Forecast
import pl.slyberry.remote.WeatherRemoteRepository

private const val FORECAST_PERIOD_IN_DAYS = 10
private val API_KEY = "a46ad2547acbfe58065c23c7d9aea71d"

internal class WeatherRemoteRepositoryImpl(private val api: OpenWeatherApi) : WeatherRemoteRepository {

  override fun getForecast(city: City): Single<Forecast> {
    return api.getForecast(city.value, FORECAST_PERIOD_IN_DAYS, API_KEY)
      .map { it.toDomain() }
  }
}
