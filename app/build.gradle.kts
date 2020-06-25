import pl.slyberry.buildsrc.Dependencies
import pl.slyberry.buildsrc.Libraries.implementKoin
import pl.slyberry.buildsrc.Modules

plugins {
    id("com.android.application")
    id("shared-gradle-plugin")
}

dependencies {
    implementation(project(Modules.FEATURE_PREVIEW))
    implementation(project(Modules.LIB_REPOSITORY))
    implementation(project(Modules.LIB_REMOTE))

    implementKoin()

    implementation(Dependencies.DATE)
    implementation(Dependencies.MATERIAL)
}
