package com.example.campingwithcompose.core.ui.navigation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.campingwithcompose.core.ui.R
import com.togitech.ccp.component.TogiCountryCodePicker
import com.togitech.ccp.data.CountryData

@Composable
fun GenericPasswordScreen(
    modifier: Modifier,
    title: String,
    description: String,
    userInputType: ScreenInputType,
    otpCount: Int = 5,
    navigationAction: () -> Unit,
    onSendActionSuccess: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var value by rememberSaveable {
            mutableStateOf("")
        }
        var isNumberValid: Boolean by rememberSaveable { mutableStateOf(false) }

        Toolbar(
            modifier = Modifier
                .align(Alignment.Start),
            navigationAction = navigationAction,
            title = title
        )

        Text(
            text = description,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 28.dp),
            style = MaterialTheme.typography.labelLarge,
            lineHeight = 24.sp,
        )

        when (userInputType) {

            ScreenInputType.OTP -> OtpComponent(
                otpText = value,
                onOtpTextChange = { otp ->
                    value = otp
                },
                otpCount = otpCount

            )

            ScreenInputType.PHONE -> TogiCountryCodePicker(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                onValueChange = { (_, phone), isValid ->
                    value = phone
                    isNumberValid = isValid
                },
                label = { Text("Phone Number") },
                fallbackCountry = CountryData.Tunisia
            )

            ScreenInputType.TEXTFILED -> CwcTextFiled()

        }

        CwcButton(
            onCLick = onSendActionSuccess,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 40.dp),
            enabled = (isNumberValid && userInputType == ScreenInputType.PHONE) || (value.length == otpCount && userInputType == ScreenInputType.OTP)
        ) {
            Text(text = stringResource(id = R.string.send))
        }


    }
}


@Preview(
    showSystemUi = true
)
@Composable
fun ToolbarPreview() {
    GenericPasswordScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        otpCount = 6,
        title = "Confirm OTP",
        description = "Please confirm your 4 digit OTP. which is sent on this number +1202-555-0174 Change number.",
        userInputType = ScreenInputType.OTP,
        navigationAction = {}
    ) {

    }
}


enum class ScreenInputType {
    PHONE, OTP, TEXTFILED
}
