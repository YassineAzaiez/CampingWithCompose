package com.example.campingwithcompose.core.ui.navigation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.compose.CampingWithComposeTheme
import com.example.compose.ThemePreviews


@Composable
fun CwcTextFiled(
    modifier: Modifier = Modifier,
    label: String = "",
    maxLines: Int = 1,
    inputType: KeyboardOptions = KeyboardOptions.Default

) {
    Column(modifier = modifier) {
        var inputText by remember {
            mutableStateOf(TextFieldValue(""))
        }
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onTertiaryContainer
            )
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            value = inputText,
            maxLines = maxLines,
            keyboardOptions = inputType,
            label = {},
            colors = TextFieldDefaults.colors(

                focusedIndicatorColor = MaterialTheme.colorScheme.outlineVariant, // Set the focused line color to transparent
                unfocusedIndicatorColor = MaterialTheme.colorScheme.outlineVariant, // Set the unfocused line color to transparent // Set the disabled line color to transparent
                focusedContainerColor = MaterialTheme.colorScheme.background,
                unfocusedContainerColor = MaterialTheme.colorScheme.background,
            ),
            visualTransformation = if (inputType.keyboardType == KeyboardType.Password) PasswordVisualTransformation() else VisualTransformation.None,
            textStyle = MaterialTheme.typography.bodyLarge,
            onValueChange = {
                inputText = it
            }
        )


    }
}


@ThemePreviews
@Composable
fun TextFiledComposablePreview() {

    CampingWithComposeTheme {
        Surface {
            CwcTextFiled(label = "Email")
        }
    }
}