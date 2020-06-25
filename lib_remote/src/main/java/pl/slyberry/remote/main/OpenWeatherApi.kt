package pl.slyberry.remote.main

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

internal interface OpenWeatherApi {

  @GET("data/2.5/forecast")
  fun getForecast(
    @Query("q") city: String,
    @Query("cnt") days: Int,
    @Query("appid") appId: String
  ): Single<ForecastJson>
}
