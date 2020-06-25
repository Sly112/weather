package pl.slyberry.buildsrc

import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
  const val LIFECYCLE = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
  const val LIFECYCLE_COMMON = "androidx.lifecycle:lifecycle-common-java8:${Versions.LIFECYCLE}"
  const val LIFECYCLE_SCOPE = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
  const val LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
  const val DATE = "com.jakewharton.threetenabp:threetenabp:${Versions.DATE}"
  const val FRAGMENT = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT}"
  const val SWIPE_REFRESH_LAYOUT = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPE_REFRESH_LAYOUT}"

  const val RX_ANDROID = "io.reactivex.rxjava2:rxandroid:${Versions.RX_ANDROID}"
  const val RX_JAVA = "io.reactivex.rxjava2:rxjava:${Versions.RX_JAVA}"

  const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
  const val COORDINATOR = "androidx.constraintlayout:constraintlayout:${Versions.COORDINATOR}"

  const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
  const val RETROFIT_RX = "com.squareup.retrofit2:adapter-rxjava2:${Versions.RETROFIT}"
  const val RETROFIT_LOGS = "com.squareup.okhttp3:logging-interceptor:${Versions.RETROFIT_LOGS}"
  const val MOSHI_CONVERTER = "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT}"

  object Koin {
    const val MAIN = "org.koin:koin-android:${Versions.KOIN}"
    const val SCOPE = "org.koin:koin-android-scope:${Versions.KOIN}"
    const val VIEW_MODEL = "org.koin:koin-android-viewmodel:${Versions.KOIN}"
  }
}

object Versions {
  const val LIFECYCLE = "2.2.0"
  const val MATERIAL = "1.1.0"
  const val COORDINATOR = "2.0.0-beta4"
  const val KOIN = "2.1.5"
  const val LIVE_EVENT = "1.2.0"
  const val FRAGMENT = "1.2.5"
  const val SWIPE_REFRESH_LAYOUT = "1.1.0"
  const val RETROFIT = "2.9.0"
  const val RETROFIT_LOGS = "3.8.0"
  const val RX_JAVA = "2.2.15"
  const val RX_ANDROID = "2.1.1"
  const val DATE = "1.2.4"
}

object Libraries {

  fun DependencyHandler.implementKoin() {
    add("implementation", Dependencies.Koin.MAIN)
    add("implementation", Dependencies.Koin.SCOPE)
    add("implementation", Dependencies.Koin.VIEW_MODEL)
  }
}
