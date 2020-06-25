import pl.slyberry.buildsrc.Dependencies
import pl.slyberry.buildsrc.Libraries.implementKoin
import pl.slyberry.buildsrc.Modules

plugins {
    id("com.android.library")
    id("shared-gradle-plugin")
}

dependencies {
    implementation(project(Modules.LIB_COMMON))
    implementation(project(Modules.LIB_REPOSITORY))
    implementation(project(Modules.LIB_DOMAIN))

    implementKoin()

    implementation(Dependencies.RX_ANDROID)
    implementation(Dependencies.RX_JAVA)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.LIVE_DATA)
    implementation(Dependencies.SWIPE_REFRESH_LAYOUT)
    implementation(Dependencies.COORDINATOR)
    implementation(Dependencies.FRAGMENT)
}
