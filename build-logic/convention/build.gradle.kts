@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}


java {
    toolchain { languageVersion.set(JavaLanguageVersion.of(17)) }
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "campingWithCompose.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "campingWithCompose.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidHilt") {
            id = "campingWithCompose.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "campingWithCompose.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "campingWithCompose.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("kotlinHilt") {
            id = "campingWithCompose.kotlin.hilt"
            implementationClass = "KotlinHiltConventionPlugin"
        }
        register("kotlinLibrary") {
            id = "campingWithCompose.kotlin.library"
            implementationClass = "KotlinLibraryConventionPlugin"
        }

        register("androidLibraryFeature") {
            id = "campingWithCompose.library.feature"
            implementationClass = "AndroidLibraryFeatureConventionPlugin"
        }
    }

}
