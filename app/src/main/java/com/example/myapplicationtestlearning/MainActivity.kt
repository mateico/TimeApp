package com.example.myapplicationtestlearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplicationtestlearning.feature_coindesk.domain.presentation.CurrentTimeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel: CurrentTimeViewModel = hiltViewModel()
            val state = viewModel.state.value
            val scaffoldState = rememberScaffoldState()

            Scaffold(
                scaffoldState = scaffoldState
            ) {
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                ) {

                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {

                    Text(text = viewModel.state.value.currentTime.dateTime)
                    Button(
                        modifier=Modifier

                            .padding(all=0.dp),
                        onClick = {
                            viewModel.onGetCurrentTime()
                        },content={
                            Text(
                                text = "Click Me")
                        })
                }
            }

        }
    }
}