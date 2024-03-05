package com.example.campingwithcompose.core.ui.navigation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.campingwithcompose.core.ui.R
import com.example.compose.CampingWithComposeTheme
import com.example.compose.ThemePreviews


@Composable
fun EmptyScreen(
    modifier: Modifier,
    description: Int,
    title: Int? = null,
    image: Int,
    button: @Composable (RowScope.() -> Unit)? = null

) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(24.dp))
        title?.let {
            Text(
                text = stringResource(id = title),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Text(
            text = stringResource(id = description),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(24.dp))
        if (button != null) {
            button
        }


    }
}

@ThemePreviews
@Composable
fun EmptyScreenPreview() {
    CampingWithComposeTheme {
        EmptyScreen(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 20.dp),
            description = R.string.successful_registration,
            title = R.string.login,
            image = R.drawable.ic_add_activity
        ) {
            CwcButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                onCLick = { }) {
                Text(text = stringResource(id = R.string.login))
            }
        }
    }
}