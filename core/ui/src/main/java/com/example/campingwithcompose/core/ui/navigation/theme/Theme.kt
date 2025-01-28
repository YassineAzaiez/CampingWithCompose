package com.example.campingwithcompose.core.ui.navigation.theme

import android.app.Activity
import android.content.res.Configuration
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat


private val LightColorScheme = lightColorScheme(
    primary = green416900,
    onPrimary = white,
    primaryContainer = greenACF847,
    onPrimaryContainer = green102000,
    secondary = green586249,
    onSecondary = white,
    secondaryContainer = greenDCE7C7,
    onSecondaryContainer = green161E0B,
    tertiary = green386663,
    onTertiary = white,
    tertiaryContainer = blueBCECE7,
    onTertiaryContainer = blue00201E,
    error = redBA1A1A,
    errorContainer = redFFDAD6,
    onError = white,
    onErrorContainer = red410002,
    background = yellowFDFCF5,
    onBackground = green1B1C18,
    surface = yellowFDFCF5,
    onSurface = green1B1C18,
    surfaceVariant = greenE1E4D5,
    onSurfaceVariant = green44483D,
    outline = yellowF2F1E9,
    inverseOnSurface = yellowF2F1E9,
    inverseSurface = green30312C,
    inversePrimary = green91DB2A,
    surfaceTint = green416900,
    outlineVariant = greenC5C8BA,
    scrim = black,
)


private val DarkColorScheme = darkColorScheme(
    primary = green91DB2A,
    onPrimary = green1F3700,
    primaryContainer = green304F00,
    onPrimaryContainer = greenACF847,
    secondary = greenC0CBAC,
    onSecondary = green2A331E,
    secondaryContainer = green404A33,
    onSecondaryContainer = greenDCE7C7,
    tertiary = blueA0D0CB,
    onTertiary = blue003734,
    tertiaryContainer = blue1F4E4B,
    onTertiaryContainer = blueBCECE7,
    error = redFFB4AB,
    errorContainer = red93000A,
    onError = red690005,
    onErrorContainer = redFFDAD6,
    background = green1B1C18,
    onBackground = yellowE3E3DB,
    surface = green1B1C18,
    onSurface = yellowE3E3DB,
    surfaceVariant = green44483D,
    onSurfaceVariant = greenC5C8BA,
    outline = green8F9285,
    inverseOnSurface = green1B1C18,
    inverseSurface = green416900,
    inversePrimary = green416900,
    surfaceTint = green91DB2A,
    outlineVariant = green44483D,
    scrim = black,
)

@Composable
fun CampingWithComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, name = "Light theme", showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark theme",showSystemUi = true)
annotation class ThemePreviews