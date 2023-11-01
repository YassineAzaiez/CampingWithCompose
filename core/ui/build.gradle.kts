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
    with(getLibs()) {
        api(platform(getLib("compose.bom")))
        api(getLib("activity.compose"))
        api(getLib("compose.ui"))
        api(getLib("compose.foundation"))
        api(getLib("compose.graphics"))
        api(getLib("material3"))

        api(getLib("navigation"))
        api(getLib("navigation.annimation"))

        api(getLib("androidx.lifecycle.viewModel.ktx"))
        api(getLib("androidx.lifecycle.viewModel.compose"))
        api(getLib("androidx.lifecycle.runtime.compose"))
        api(getLib("ui.tooling.preview"))
    }
}

