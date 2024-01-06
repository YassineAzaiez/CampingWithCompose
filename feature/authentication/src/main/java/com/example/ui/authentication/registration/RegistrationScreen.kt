package com.example.ui.authentication.registration

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.campingwithcompose.core.ui.R
import com.example.campingwithcompose.core.ui.navigation.component.CwcButton
import com.example.campingwithcompose.core.ui.navigation.component.CwcOutlinedButton
import com.example.campingwithcompose.core.ui.navigation.component.CwcTextFiled
import com.example.compose.CampingWithComposeTheme
import com.example.compose.ThemePreviews
import com.togitech.ccp.component.TogiCountryCodePicker
import com.togitech.ccp.data.CountryData

@Composable
fun RegistrationRoute(
    registrationViewModel: RegistrationViewModel
) {
    RegistrationScreen(
        registrationViewModel::onRegisterClicked,
        //TODO update this function
        registrationViewModel::onRegisterClicked
    )
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable

private fun RegistrationScreen(
    onRegisterClicked: () -> Unit, onLoginClicked: () -> Unit
) {

    val focusRequester = remember { FocusRequester() }
    Column(
        modifier = Modifier.padding(top = 100.dp, start = 40.dp, end = 40.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_login),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth(),
        )

        TogiCountryCodePicker(

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp)
                .focusRequester(FocusRequester.Cancel),
            onValueChange = { (_, _), isValid ->
//                value = phone
//                isNumberValid = isValid
            },
            label = { Text("Phone Number", style = MaterialTheme.typography.bodySmall) },
            fallbackCountry = CountryData.Tunisia
        )

        CwcTextFiled(
            label = "Name",
            modifier = Modifier
                .padding(top = 20.dp)
                .focusRequester(focusRequester),
            inputType = KeyboardOptions(
                imeAction = ImeAction.Next, keyboardType = KeyboardType.Email
            )
        )
        CwcTextFiled(
            label = "Email", modifier = Modifier.padding(top = 20.dp),
            inputType = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            )
        )



        CwcTextFiled(
            label = "Password",
            modifier = Modifier.padding(top = 20.dp),
            inputType = KeyboardOptions(
                imeAction = ImeAction.Done, keyboardType = KeyboardType.Password
            )
        )

        CwcButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, bottom = 20.dp),
            onCLick = onRegisterClicked,
            contentPadding = PaddingValues(vertical = 13.dp)
        ) {
            Text(text = stringResource(id = R.string.register))
        }

        CwcOutlinedButton(
            modifier = Modifier.fillMaxWidth(), onClick = onLoginClicked,
            contentPadding = PaddingValues(vertical = 13.dp)
        ) {
            Text(text = stringResource(id = R.string.login))
        }

    }
}

@ThemePreviews
@Composable
fun RegistrationScreenPreview() {
    CampingWithComposeTheme {
        RegistrationScreen({ }, { })
    }
}