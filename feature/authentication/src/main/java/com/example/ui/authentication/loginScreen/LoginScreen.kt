package com.example.ui.authentication.loginScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.campingwithcompose.authentication.R
import com.example.campingwithcompose.core.ui.navigation.comospables.LoginButton
import com.example.campingwithcompose.core.ui.navigation.comospables.TextFiledComposable

@Composable
fun LoginScreen(
    onUserLogin: () -> Unit,
    onRegisterBtnClick: () -> Unit,
    onForgetPassword: () -> Unit
) {
    Column(modifier = Modifier.padding(top = 100.dp, start = 40.dp, end = 40.dp)) {
        Image(
            painter = painterResource(id = com.example.campingwithcompose.core.ui.R.drawable.ic_login),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth(),
        )

        TextFiledComposable(
            label = "Email",
            modifier = Modifier.padding(top = 60.dp),
            inputType = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email
            )
        )
        TextFiledComposable(
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
                .padding(top = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Forgot Password?")
        }

        LoginButton(
            Modifier
                .fillMaxWidth()
                .padding(
                    top = 30.dp
                )
                .background(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.primary
                ), onUserLogin
        )

        RegisterButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 30.dp
                ), shape = RoundedCornerShape(8.dp),
            border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary)

        )

    }


}

@Composable
fun RegisterButton(
    modifier: Modifier,
    shape: Shape = ButtonDefaults.outlinedShape,
    border: BorderStroke? = ButtonDefaults.outlinedButtonBorder
) {
    OutlinedButton(
        border = border,
        shape = shape,
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 12.dp),
        onClick = { /*TODO*/ }) {
        Text("Register")
    }
}