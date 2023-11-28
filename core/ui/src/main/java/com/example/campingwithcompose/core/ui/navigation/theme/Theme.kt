package com.example.compose

import android.app.Activity
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
import androidx.core.view.WindowCompat
import com.example.campingwithcompose.core.ui.navigation.theme.Typography
import com.example.campingwithcompose.core.ui.navigation.theme.black
import com.example.campingwithcompose.core.ui.navigation.theme.blue00201E
import com.example.campingwithcompose.core.ui.navigation.theme.blue003734
import com.example.campingwithcompose.core.ui.navigation.theme.blue1F4E4B
import com.example.campingwithcompose.core.ui.navigation.theme.blueA0D0CB
import com.example.campingwithcompose.core.ui.navigation.theme.blueBCECE7
import com.example.campingwithcompose.core.ui.navigation.theme.green102000
import com.example.campingwithcompose.core.ui.navigation.theme.green161E0B
import com.example.campingwithcompose.core.ui.navigation.theme.green1B1C18
import com.example.campingwithcompose.core.ui.navigation.theme.green1F3700
import com.example.campingwithcompose.core.ui.navigation.theme.green2A331E
import com.example.campingwithcompose.core.ui.navigation.theme.green30312C
import com.example.campingwithcompose.core.ui.navigation.theme.green304F00
import com.example.campingwithcompose.core.ui.navigation.theme.green386663
import com.example.campingwithcompose.core.ui.navigation.theme.green404A33
import com.example.campingwithcompose.core.ui.navigation.theme.green416900
import com.example.campingwithcompose.core.ui.navigation.theme.green44483D
import com.example.campingwithcompose.core.ui.navigation.theme.green586249
import com.example.campingwithcompose.core.ui.navigation.theme.green8F9285
import com.example.campingwithcompose.core.ui.navigation.theme.green91DB2A
import com.example.campingwithcompose.core.ui.navigation.theme.greenACF847
import com.example.campingwithcompose.core.ui.navigation.theme.greenC0CBAC
import com.example.campingwithcompose.core.ui.navigation.theme.greenC5C8BA
import com.example.campingwithcompose.core.ui.navigation.theme.greenDCE7C7
import com.example.campingwithcompose.core.ui.navigation.theme.greenE1E4D5
import com.example.campingwithcompose.core.ui.navigation.theme.red410002
import com.example.campingwithcompose.core.ui.navigation.theme.red690005
import com.example.campingwithcompose.core.ui.navigation.theme.red93000A
import com.example.campingwithcompose.core.ui.navigation.theme.redBA1A1A
import com.example.campingwithcompose.core.ui.navigation.theme.redFFB4AB
import com.example.campingwithcompose.core.ui.navigation.theme.redFFDAD6
import com.example.campingwithcompose.core.ui.navigation.theme.white
import com.example.campingwithcompose.core.ui.navigation.theme.yellowE3E3DB
import com.example.campingwithcompose.core.ui.navigation.theme.yellowF2F1E9
import com.example.campingwithcompose.core.ui.navigation.theme.yellowFDFCF5


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