import com.android.build.gradle.LibraryExtension
import com.example.campingwithcompose.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("campingWithCompose.android.library")
        }

        extensions.configure<LibraryExtension> {
            configureAndroidCompose(this)


        }
    }
}
