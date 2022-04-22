package com.samsdk.alertprogress

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.samsdk.alertprogress.component.DecreaseCircularProgressbar
import com.samsdk.alertprogress.ui.theme.Purple500
import com.samsdk.alertprogress.viewmodel.MainViewModel

@Composable
fun CircularProgressbar() {
    val scaffoldState = rememberScaffoldState()
    val viewModel: MainViewModel = viewModel()
    val decreaseSec = viewModel.decreaseSec.observeAsState()
    val increaseSec = viewModel.increaseSec.observeAsState()

    viewModel.decreaseCountDown(300000L)
    viewModel.increaseCountDown(300000L)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Box() {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.background(Purple500).background(Purple500).padding(15.dp)
                    ) {
                        Text(
                            text = "Circular Progressbar",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            text = "Decrease Circular Progressbar",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.padding(10.dp))

                        DecreaseCircularProgressbar(percentage = decreaseSec.value!!.toFloat())

                        Spacer(modifier = Modifier.padding(30.dp))

                        Text(
                            text = "Increase Circular Progressbar",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.padding(10.dp))

                        DecreaseCircularProgressbar(percentage = decreaseSec.value!!.toFloat())
                    }
                }
            }
        }
    }
}