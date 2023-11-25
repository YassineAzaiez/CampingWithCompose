@file:Suppress("UnstableApiUsage")

package com.example.campingwithcompose

import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.Packaging
import ext.getLibs
import ext.getVersion
import org.gradle.api.Project

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *,*>,
) = with(commonExtension) {

    defaultConfig.minSdk = 26
    compileSdk = 33
    compileSdkPreview = "UpsideDownCake"
    buildFeatures {
        compose = true
        buildConfig = true


    }
    packaging {
        resources.excludes.addAll(
            listOf(
                "META-INF/*",
                )
        )
    }
    composeOptions {
        kotlinCompilerExtensionVersion = getLibs().getVersion("androidxComposeCompiler").toString()
    }
}
