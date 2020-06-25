package pl.slyberry.weather

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pl.slyberry.preview.weatherForecastModule
import pl.slyberry.remote.remoteModule
import pl.slyberry.repository.repositoryModule

class WeatherApp : Application() {

  override fun onCreate() {
    super.onCreate()

    AndroidThreeTen.init(this)

    startKoin {
      androidContext(this@WeatherApp)
      modules(
        remoteModule,
        repositoryModule,
        weatherForecastModule
      )
    }
  }
}
