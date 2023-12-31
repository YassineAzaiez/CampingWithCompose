import ext.api
import ext.getLib
import ext.getLibs

plugins {

    id("campingWithCompose.android.library.compose")
}

android {
    namespace = "com.example.campingwithcompose.core.ui"
}

dependencies {

    implementation(libs.androidx.junit.ktx)
    androidTestImplementation("junit:junit:4.12")
    with(getLibs()) {
        api(platform(getLib("compose.bom")))
        api(getLib("activity.compose"))
        api(getLib("compose.ui"))
        api(getLib("compose.foundation"))
        api(getLib("compose.graphics"))
        api(getLib("material3"))
        api( getLib("androidx.hilt.navigation.compose"))
        api(getLib("navigation"))
        api(getLib("navigation.annimation"))

        api(getLib("androidx.lifecycle.viewModel.ktx"))
        api(getLib("androidx.lifecycle.viewModel.compose"))
        api(getLib("androidx.lifecycle.runtime.compose"))
        api(getLib("ui.tooling.preview"))
        api(libs.ui.tooling)
        implementation("androidx.compose.material:material:1.5.4")
        implementation(libs.phone.code.picker)
    }

}


