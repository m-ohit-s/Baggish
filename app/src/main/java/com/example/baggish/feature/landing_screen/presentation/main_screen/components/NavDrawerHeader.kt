package com.example.baggish.feature.landing_screen.presentation.main_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.baggish.R

@Composable
fun NavDrawerHeaderWithoutAuth(modifier: Modifier = Modifier){
    Box(modifier = modifier){
        Column {
            Text(
                text = stringResource(
                    id = R.string.nav_drawer_header_title
                ) + " " + stringResource(
                    id = R.string.nav_drawer_header_title_no_auth
                ),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 8.dp, top = 16.dp)
            )
            Row(verticalAlignment = Alignment.Top) {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = stringResource(id = R.string.nav_drawer_title_login_button_text))
                }
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = stringResource(id = R.string.nav_drawer_title_signup_button_text))
                }
            }
            Divider(color = MaterialTheme.colorScheme.inversePrimary)
        }
    }
}



@Composable
fun NavDrawerHeaderWithAuth(modifier: Modifier = Modifier, name: String = ""){
    Box(modifier = modifier){
        Text(
            text = stringResource(
                id = R.string.nav_drawer_header_title
            ) + " " + name,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 8.dp, top = 16.dp)
        )
    }
}