@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("campingWithCompose.android.library.compose")
    id("campingWithCompose.android.hilt")
}

android {
    namespace = "com.example.campingwithcompose.navigation"

}


dependencies {

    implementation(libs.navigation)
    implementation(project(":core:common"))


}