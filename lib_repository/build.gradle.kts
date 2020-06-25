import pl.slyberry.buildsrc.Dependencies
import pl.slyberry.buildsrc.Libraries.implementKoin
import pl.slyberry.buildsrc.Modules

plugins {
    id("com.android.library")
    id("shared-gradle-plugin")
}

dependencies {
    implementation(project(Modules.LIB_REMOTE))
    implementation(project(Modules.LIB_COMMON))
    implementation(project(Modules.LIB_DOMAIN))

    implementKoin()

    implementation(Dependencies.RX_ANDROID)
    implementation(Dependencies.RX_JAVA)
}
