package com.example.campingwithcompose.core.ui.navigation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.CampingWithComposeTheme
import com.example.compose.ThemePreviews

@Composable
fun CwcButton(
    onCLick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {

    Button(
        modifier = modifier,
        onClick = onCLick,
        enabled = enabled,
        contentPadding = contentPadding,
        content = content,

        )

}


@Composable
fun CwcOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.inversePrimary,
        ),
        border = BorderStroke(
            width = CwcButtonDefaults.ButtonBorderWidth,
            color = if (enabled) {
                MaterialTheme.colorScheme.inversePrimary
            } else {
                MaterialTheme.colorScheme.outlineVariant
            },
        ),
        contentPadding = contentPadding,
        content = content,
    )
}

object CwcButtonDefaults {
    val ButtonBorderWidth = 1.dp
}

@ThemePreviews
@Composable
fun CwcButtonPreview() {
    CampingWithComposeTheme {

        CwcButton(onCLick = {}) { Text("Test button") }

    }
}


@ThemePreviews
@Composable
fun CwcOutlinedButtonPreview() {
    CampingWithComposeTheme {

        Surface {
            CwcOutlinedButton(
                onClick = {}
            ) {
                Text(text = "Register")
            }
        }

    }
}