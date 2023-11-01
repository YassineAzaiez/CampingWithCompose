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

    }
}
