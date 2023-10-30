package com.example.campingwithcompose.ui.screens.forgetPassword

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.campingwithcompose.R
import com.example.campingwithcompose.utils.comospables.GenericPasswordScreen
import com.example.campingwithcompose.utils.comospables.ScreenInputType

@Composable
fun ForgetPasswordScreen(
    navigationAction: () -> Unit,
    onSendActionSuccess: () -> Unit
) {

    GenericPasswordScreen(
        modifier = Modifier.fillMaxWidth(),
        navigationAction = navigationAction,
        title = stringResource(id = R.string.forget_password),
        description = stringResource(id = R.string.forget_password_description),
        userInputType = ScreenInputType.PHONE
    ){}
}