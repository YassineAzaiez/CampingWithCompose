package com.example.campingwithcompose.ui.screens.splashScreen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.campingwithcompose.R
import com.example.campingwithcompose.ui.navigation.screenDestination.Screen
import com.example.campingwithcompose.ui.theme.Green500
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navigateToNextScreen : ()->Unit) {

    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = null) {
        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(
                durationMillis = 2000,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000)
        navigateToNextScreen()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Green500),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_splash_logo),
            contentDescription = "logo",
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .scale(scale.value),
            fontSize = 16.sp,
            text = "Makes your camping more easy, next level. and helps you to follow your plannings.",
            color = Color.White,
            textAlign = TextAlign.Center,
        )
    }
}