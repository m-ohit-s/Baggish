package com.example.baggish.feature.landing_screen.presentation.main_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogoutBottomSheet(
    modifier: Modifier = Modifier,
    onDismiss: ()->Unit,
    sheetColor: Color = MaterialTheme.colorScheme.inversePrimary,
    buttonColor: Color = Color.Black,
    sheetState: SheetState,
    onYes: ()->Unit,
    onNo: ()->Unit
) {
    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = { onDismiss() },
        containerColor = sheetColor,

    ) {
        Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Are you sure? You want to logout?")
            Button(onClick = { onYes() }, colors = ButtonDefaults.buttonColors(buttonColor)) {
                Text(text = "Yes")
            }
            Button(onClick = { onNo() }, colors = ButtonDefaults.buttonColors(buttonColor)) {
                Text(text = "No")
            }
        }
    }
}