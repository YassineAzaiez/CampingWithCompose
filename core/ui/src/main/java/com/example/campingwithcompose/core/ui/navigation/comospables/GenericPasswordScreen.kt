package com.example.campingwithcompose.core.ui.navigation.comospables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.campingwithcompose.core.ui.R


@Composable
fun GenericPasswordScreen(
    modifier: Modifier,
    title: String,
    description: String,
    userInputType: ScreenInputType,
    navigationAction: () -> Unit,
    onSendActionSuccess: () -> Unit
) {
    Column(
        modifier
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var otpValue by remember {
            mutableStateOf("")
        }
        Toolbar(
            modifier = Modifier
                .padding(top = 10.dp)
                .align(Alignment.Start),
            navigationAction = navigationAction,
            title = title
        )

        Text(
            text = description,
            modifier = Modifier.padding(vertical = 24.dp),
            style = MaterialTheme.typography.labelLarge,
            lineHeight = 24.sp,
        )

        when (userInputType) {

            ScreenInputType.OTP -> OtpComponent(
                modifier = Modifier,
                otpText = otpValue,
                onOtpTextChange = { value ->
                    otpValue = value
                })

            ScreenInputType.TEXTFILED -> TextFiledComposable()
            else -> {}

        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 40.dp),
            onClick = onSendActionSuccess
        ) {
            Text(text = stringResource(id = R.string.send))
        }


    }
}


@Composable
fun Toolbar(
    modifier: Modifier,
    navigationAction: () -> Unit,
    title: String
) {
    Row(
        modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = navigationAction,
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "Arrow left"
            )
        }

        Text(text = title, style = MaterialTheme.typography.titleLarge)
    }
}


@Preview
@Composable
fun ToolbarPreview() {
   GenericPasswordScreen(
       modifier = Modifier
           .fillMaxSize()
           .background(MaterialTheme.colorScheme.background),
       title = "Confirm OTP",
       description = "Please confirm your 4 digit OTP. which is sent on this number +1202-555-0174 Change number.",
       userInputType = ScreenInputType.OTP,
       {}
   ) {}
}


enum class ScreenInputType {
    PHONE, OTP, TEXTFILED
}
