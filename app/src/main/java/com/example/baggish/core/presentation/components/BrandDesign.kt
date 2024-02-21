package com.example.baggish.core.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocalMall
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.baggish.R
import com.example.baggish.ui.theme.BaggishTheme

@Composable
fun BrandDesign(modifier: Modifier=Modifier, color: Color= Color.Black){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Rounded.LocalMall,
            contentDescription = stringResource(id = R.string.brand_logo_description),
            tint = color,
            modifier = Modifier.size(70.dp)
        )
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.headlineLarge,
            color = color,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 24.dp),
        )
    }
}

@Preview
@Composable
fun BrandDesignPreview(){
    BaggishTheme {
        BrandDesign()
    }
}