@file:Suppress("UnstableApiUsage")

package com.example.campingwithcompose

import com.android.build.api.dsl.CommonExtension
import ext.getLibs
import ext.getVersion
import org.gradle.api.Project

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *,*>,
) = with(commonExtension) {

    compileSdk = 33

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = getLibs().getVersion("androidxComposeCompiler").toString()
    }
}
