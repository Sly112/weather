package pl.slyberry.preview.viewmodel

import androidx.lifecycle.MutableLiveData
import pl.slyberry.common.ErrorResult
import pl.slyberry.common.LoadingResult
import pl.slyberry.common.SuccessResult
import pl.slyberry.domain.City
import pl.slyberry.preview.view.ErrorViewEntity
import pl.slyberry.preview.view.LoadingViewEntity
import pl.slyberry.preview.view.WeatherViewEntity
import pl.slyberry.repository.GetForecastUseCase

class WeatherForecastViewModel(private val useCase: GetForecastUseCase) : DisposableViewModel() {

  val viewEntity = MutableLiveData<WeatherViewEntity>()

  fun query(city: String) {
    useCase.query(City(city))
      .subscribe {
        viewEntity.value = when (it) {
          is LoadingResult -> LoadingViewEntity
          is SuccessResult -> it.data.toViewEntity()
          is ErrorResult -> ErrorViewEntity
        }
      }.let { addDisposable(it) }
  }
}
