package pl.slyberry.preview.view

sealed class WeatherViewEntity

object LoadingViewEntity : WeatherViewEntity()
data class SuccessViewEntity(val items: List<WeatherItemViewEntity>) : WeatherViewEntity()
object ErrorViewEntity : WeatherViewEntity()
