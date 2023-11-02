package com.example.campingwithcompose

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension

internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *,*>,
) = with(commonExtension) {

    compileSdk = 33

    defaultConfig {

        minSdk = 26

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }


    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    kotlinExtension.jvmToolchain(17)
}

private fun CommonExtension<*, *, *, *,*>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}