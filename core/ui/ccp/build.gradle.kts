plugins {
    id("campingWithCompose.library.feature")
    id("campingWithCompose.android.library.compose")

}

android {
    namespace = "com.example.ccp"
}
dependencies{
    implementation(libs.kotlinx.immutable)
    implementation(libs.libphonenumber)
}