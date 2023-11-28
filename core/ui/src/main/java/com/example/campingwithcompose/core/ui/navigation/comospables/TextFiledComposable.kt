package com.example.campingwithcompose.core.ui.navigation.comospables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFiledComposable(
    modifier: Modifier = Modifier,
    label: String = "",
    maxLines: Int = 1,
    inputType: KeyboardOptions = KeyboardOptions.Default

) {
    Column(modifier = modifier, Arrangement.Center) {
        var inputText by remember {
            mutableStateOf(TextFieldValue(""))
        }
        Text(text = label, fontSize = 16.sp)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .padding(top = 11.dp)
                .border(width = 1.dp, color = MaterialTheme.colorScheme.outlineVariant, shape = RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.CenterStart
        ) {
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                value = inputText,
                maxLines = maxLines,
                keyboardOptions = inputType,
                visualTransformation = if (inputType.keyboardType == KeyboardType.Password) PasswordVisualTransformation() else VisualTransformation.None,
                textStyle = MaterialTheme.typography.labelMedium,
                onValueChange = {
                    inputText = it
                }
            )
            { innerTextField ->
                innerTextField()
            }
        }

    }


}

@Preview
@Composable
fun TextFiledComposablePreview() {
    TextFiledComposable(label = "Email")
}