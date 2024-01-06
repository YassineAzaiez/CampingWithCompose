package com.example.ui.authentication.loginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.campingwithcompose.core.ui.R
import com.example.campingwithcompose.core.ui.navigation.component.CwcButton
import com.example.campingwithcompose.core.ui.navigation.component.CwcOutlinedButton
import com.example.campingwithcompose.core.ui.navigation.component.CwcTextFiled
import com.example.campingwithcompose.core.ui.navigation.utils.noRippleClickable
import com.example.compose.CampingWithComposeTheme
import com.example.compose.ThemePreviews


@Composable
fun LoginRoute(
    loginViewModel: LoginViewModel
) {
    LoginScreen(
        onUserLogin = {},
        onForgetPassword = loginViewModel::navigateForgetPassword,
        onRegistration = loginViewModel::navigateRegistration
    )
}

@Composable
internal fun LoginScreen(
    onUserLogin: () -> Unit,
    onForgetPassword: () -> Unit,
    onRegistration: () -> Unit
) {
    Column(modifier = Modifier.padding(top = 100.dp, start = 40.dp, end = 40.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_login),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth(),
        )

        CwcTextFiled(
            label = "Email",
            modifier = Modifier.padding(top = 60.dp),
            inputType = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email
            )
        )
        CwcTextFiled(
            label = "Password",
            modifier = Modifier.padding(top = 20.dp),
            inputType = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            )
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .noRippleClickable { onForgetPassword.invoke() }
                .padding(top = 16.dp),
            contentAlignment = Alignment.Center,

            ) {
            Text(text = "Forgot Password?",)
        }

        CwcButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 20.dp),
            contentPadding = PaddingValues(vertical = 12.dp), onCLick = onUserLogin
        ) {
            Text(text = stringResource(id = R.string.login))
        }

        CwcOutlinedButton(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 12.dp),
            onClick = onRegistration


        ) {
            Text(text = stringResource(id = R.string.register))
        }

    }


}
@ThemePreviews
@Composable
fun LoginScreenPreview() {

    CampingWithComposeTheme {
        Surface(
            tonalElevation = 5.dp
        ) {
            LoginScreen({}, {}, {})
        }
    }
}