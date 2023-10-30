@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("campingWithCompose.android.application")
    id("campingWithCompose.android.application.compose")
    id("campingWithCompose.android.hilt")
}



android {
    namespace = "com.example.campingwithcompose"


    defaultConfig {
        applicationId = namespace

        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }


    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            merges.add("META-INF/gradle/incremental.annotation.processors")
        }
    }
}


dependencies {





    //coroutines
    implementation(libs.coroutines)

    //test
    implementation(libs.junit)
    implementation(libs.coroutines.test)

    //ui test
    androidTestImplementation(libs.ui.test.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ui.test.manifest)
    androidTestImplementation(libs.coroutines.test)
    androidTestImplementation(platform(libs.compose.bom))



}
