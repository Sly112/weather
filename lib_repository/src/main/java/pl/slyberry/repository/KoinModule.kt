package pl.slyberry.repository

import org.koin.dsl.module

val repositoryModule = module {

  factory { GetForecastUseCase(get()) }
}
