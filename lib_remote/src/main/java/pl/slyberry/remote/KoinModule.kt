package pl.slyberry.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import pl.slyberry.remote.main.OpenWeatherApi
import pl.slyberry.remote.main.WeatherRemoteRepositoryImpl
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

val remoteModule = module {
  single { WeatherRemoteRepositoryImpl(get()) as WeatherRemoteRepository }
  single { provideGithubApi(get()) }
  single { provideRetrofitClient() }
}

private fun provideGithubApi(retrofit: Retrofit) = retrofit.create(OpenWeatherApi::class.java)

private fun provideRetrofitClient(): Retrofit {
  val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
  }
  val httpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

  return Retrofit.Builder()
    .baseUrl("https://openweathermap.org/")
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create())
    .client(httpClient)
    .build()
}