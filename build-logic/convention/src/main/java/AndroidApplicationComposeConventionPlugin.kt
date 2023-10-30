import com.android.build.api.dsl.ApplicationExtension
import com.example.campingwithcompose.configureAndroidCompose

import ext.getLib
import ext.getLibs
import ext.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("com.android.application")
        }

        extensions.configure<ApplicationExtension> {
            configureAndroidCompose(this)
        }

        dependencies {
            with(getLibs()) {
                implementation(platform(getLib("compose.bom")))
                implementation(getLib("activity.compose"))
                implementation(getLib("compose.ui"))
                implementation(getLib("compose.foundation"))
                implementation(getLib("compose.graphics"))
                implementation(getLib("material3"))

                implementation(getLib("navigation"))
                implementation(getLib("navigation.annimation"))

                implementation(getLib("androidx.lifecycle.viewModel.ktx"))
                implementation(getLib("androidx.lifecycle.viewModel.compose"))
                implementation(getLib("androidx.lifecycle.runtime.compose"))
                implementation(getLib("ui.tooling.preview"))
            }
        }
    }
}
