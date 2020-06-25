import pl.slyberry.buildsrc.Dependencies
import pl.slyberry.buildsrc.Libraries.implementKoin
import pl.slyberry.buildsrc.Modules

plugins {
    id("com.android.library")
    id("shared-gradle-plugin")
}

dependencies {
    implementation(project(Modules.LIB_DOMAIN))

    implementKoin()

    implementation(Dependencies.DATE)
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_RX)
    implementation(Dependencies.RETROFIT_LOGS)
    implementation(Dependencies.RX_ANDROID)
    implementation(Dependencies.RX_JAVA)
    implementation(Dependencies.MOSHI_CONVERTER)
}
