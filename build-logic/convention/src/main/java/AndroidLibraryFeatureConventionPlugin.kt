
import ext.getLibs
import ext.getVersion
import ext.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidLibraryFeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("campingWithCompose.android.library")
            apply("campingWithCompose.android.hilt")
            apply("org.jetbrains.kotlin.kapt")
        }

        dependencies {
           implementation(project(":core:ui"))

        }

    }
}
