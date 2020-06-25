package pl.slyberry.remote

import io.reactivex.Single
import pl.slyberry.domain.City
import pl.slyberry.domain.Forecast

interface WeatherRemoteRepository {

  fun getForecast(city: City): Single<Forecast>
}