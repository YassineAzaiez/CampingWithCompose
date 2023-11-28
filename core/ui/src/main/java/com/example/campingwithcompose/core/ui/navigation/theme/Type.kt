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

package com.example.campingwithcompose.core.ui.navigation.theme


import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy.Companion.OptionalLocal
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.campingwithcompose.core.ui.R


/**
 * https://fonts.google.com/specimen/Montserrat
 */
private val Montserrat = FontFamily(
    Font(R.font.montserrat_regular, FontWeight.Normal, loadingStrategy = OptionalLocal),
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

        headlineSmall = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontFamily = Montserrat,
            fontSize = 24.sp,
            lineHeight = 32.sp,
            letterSpacing = 0.sp
        ),
        titleLarge = TextStyle(
            fontWeight = FontWeight.Normal,
            fontFamily = Montserrat,
            fontSize = 18.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp
        ),
        bodyLarge = TextStyle(
            fontWeight = FontWeight.Normal,
            fontFamily = Domine,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.15.sp
        ),
        bodyMedium = TextStyle(
            fontWeight = FontWeight.Medium,
            fontFamily = Montserrat,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.25.sp
        ),
        labelMedium = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontFamily = Montserrat,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp
        )
    )
}
