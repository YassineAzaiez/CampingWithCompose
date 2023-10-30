
import ext.getLib
import ext.getLibs
import ext.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("org.jetbrains.kotlin.kapt")
            apply("dagger.hilt.android.plugin")
        }

        dependencies {
            with(getLibs()) {
                implementation(  getLib("hilt"))
                implementation(getLib("hilt.compiler"))
                implementation(getLib("hilt.navigation"))
            }
        }
    }
}
