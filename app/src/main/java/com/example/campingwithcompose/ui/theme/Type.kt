/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.campingwithcompose.ui.theme


import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy.Companion.OptionalLocal
import androidx.compose.ui.text.font.FontWeight
import com.example.campingwithcompose.R


/**
 * https://fonts.google.com/specimen/Montserrat
 */
private val Montserrat = FontFamily(
    Font(R.font.montserrat_regular, loadingStrategy = OptionalLocal),
    Font(R.font.montserrat_medium, FontWeight.W500, loadingStrategy = OptionalLocal),
    Font(R.font.montserrat_semibold, FontWeight.W600, loadingStrategy = OptionalLocal)
)

/**
 * https://fonts.google.com/specimen/Domine
 */
private val Domine = FontFamily(
    Font(R.font.domine_regular, loadingStrategy = OptionalLocal),
    Font(R.font.domine_bold, FontWeight.Bold, loadingStrategy = OptionalLocal)
)

val Typography: Typography = with(Typography()) {
    copy(
        displayLarge = displayLarge.copy(fontFamily = Montserrat),
        displayMedium = displayMedium.copy(fontFamily = Montserrat),
        displaySmall = displaySmall.copy(fontFamily = Montserrat),
        headlineLarge = headlineLarge.copy(fontFamily = Montserrat),
        headlineMedium = headlineMedium.copy(fontFamily = Montserrat),
        headlineSmall = headlineSmall.copy(fontFamily = Montserrat),
        titleLarge = titleLarge.copy(fontFamily = Montserrat),
        titleMedium = titleMedium.copy(fontFamily = Montserrat),
        titleSmall = titleSmall.copy(fontFamily = Montserrat),
        bodyLarge = bodyLarge.copy(fontFamily = Domine),
        bodyMedium = bodyMedium.copy(fontFamily = Montserrat),
        bodySmall = bodySmall.copy(fontFamily = Montserrat),
        labelLarge = labelLarge.copy(fontFamily = Montserrat),
        labelMedium = labelMedium.copy(fontFamily = Montserrat),
        labelSmall = labelSmall.copy(fontFamily = Montserrat),
    )
}
