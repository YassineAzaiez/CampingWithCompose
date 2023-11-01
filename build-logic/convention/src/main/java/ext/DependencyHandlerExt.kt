package ext


import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(dependency: Any) {
    add("implementation", dependency)
}

fun DependencyHandler.api(dependency: Any) {
    add("api", dependency)
}

fun DependencyHandler.test(dependency: String) {
    add("test", dependency)
}

fun DependencyHandler.androidTest(dependency: String) {
    add("androidTest", dependency)
}

fun DependencyHandler.debugImplementation(dependency: String) {
    add("debugImplementation", dependency)
}

fun DependencyHandler.kapt(dependency: String) {
    add("kapt", dependency)
}