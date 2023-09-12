@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.hilt)
    kotlin("kapt")
}

android {
    namespace = "com.example.campingwithcompose"
    compileSdk = 33
    compileSdkPreview = "UpsideDownCake"
    defaultConfig {
        applicationId = "com.example.campingwithcompose"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.8"
    }
    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            merges.add("META-INF/gradle/incremental.annotation.processors")
        }
    }
}


dependencies {

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.material3)
    implementation(libs.ui.tooling.preview)
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.33.1-alpha")


    //compose
    implementation(platform(libs.compose.bom))
    implementation(libs.activity.compose)
    implementation(libs.compose.ui)
    implementation(libs.compose.foundation)
    implementation(libs.compose.graphics)


    //navigation
    implementation(libs.navigation)
    implementation(libs.navigation.annimation)

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

    //hilt
    implementation(libs.hilt)
    implementation(libs.hilt.navigation)
    implementation(libs.hilt.compiler)


}
