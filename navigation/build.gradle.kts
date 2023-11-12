@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("campingWithCompose.android.application.compose")
}

android {
    namespace = "com.example.campingwithcompose.navigation"
}


dependencies {

    implementation(libs.navigation)

}