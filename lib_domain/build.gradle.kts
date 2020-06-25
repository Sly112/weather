import pl.slyberry.buildsrc.Dependencies

plugins {
    id("com.android.library")
    id("shared-gradle-plugin")
}

dependencies {
    implementation(Dependencies.DATE)
}
