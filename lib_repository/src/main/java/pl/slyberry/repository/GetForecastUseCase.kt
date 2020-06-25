package pl.slyberry.repository

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pl.slyberry.common.RequestResult
import pl.slyberry.domain.City
import pl.slyberry.domain.Forecast
import pl.slyberry.remote.WeatherRemoteRepository

class GetForecastUseCase(private val remoteRepository: WeatherRemoteRepository) {

  fun query(city: City): Observable<RequestResult<Forecast>> {
    return remoteRepository.getForecast(city)
      .map { RequestResult.createSuccess(it) }
      .toObservable()
      .onErrorReturn { RequestResult.createError(it) }
      .startWith(RequestResult.createLoading())
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }
}
