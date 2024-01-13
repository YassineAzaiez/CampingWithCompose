import ext.api

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("campingWithCompose.library.feature")
    id("campingWithCompose.android.library.compose")

}

android {
    namespace = "com.example.campingwithcompose.authentication"
}
dependencies{
    implementation(project(":navigation"))
    implementation(project(":core:ui"))



}