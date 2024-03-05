package com.example.campingwithcompose.core.ui.navigation.common

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.campingwithcompose.core.ui.R
import com.example.campingwithcompose.core.ui.navigation.component.GenericPasswordScreen
import com.example.campingwithcompose.core.ui.navigation.component.ScreenInputType


@Composable
fun OtpScreen(
    source: String,
    navigationAction: () -> Unit,
) {

    GenericPasswordScreen(
        modifier = Modifier.fillMaxWidth(),
        navigationAction = {
            Log.d("OtpScreen", "OtpScreen: $source")
        },
        title = stringResource(id = R.string.otp_screen_title),
        description = stringResource(id = R.string.otp_screen_text),
        userInputType = ScreenInputType.OTP
    ) {
        navigationAction()
    }
}