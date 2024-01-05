package com.example.ui.authentication.forgetPassword

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.campingwithcompose.authentication.R
import com.example.campingwithcompose.core.ui.navigation.component.GenericPasswordScreen
import com.example.campingwithcompose.core.ui.navigation.component.ScreenInputType


@Composable
fun NewPasswordScreen() {

    GenericPasswordScreen(
        modifier = Modifier.fillMaxWidth(),
        navigationAction = {} ,
        title = stringResource(id = R.string.set_password),
        description = stringResource(id = R.string.new_password_description),
        userInputType = ScreenInputType.TEXTFILED
    ){}
}