package com.samsdk.alertprogress.alertdialog

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.samsdk.alertprogress.ui.theme.Purple500

@Composable
fun CallAlertDialog() {
    val isDialogOpen = remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
    ) {
        ShowAlertDialog(isDialogOpen)

        Button(
            onClick = {
                isDialogOpen.value = true
            },
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(0.5f)
                .height(50.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(Purple500)
        ) {
            Text(
                text = "Show Popup",
                color = Color.White
            )
        }
    }
}