@file:Suppress("UnstableApiUsage")

package com.example.campingwithcompose

import com.android.build.api.dsl.CommonExtension

internal fun configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
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

}
