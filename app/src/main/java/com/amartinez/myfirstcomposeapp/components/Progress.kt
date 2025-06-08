package com.amartinez.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.amartinez.myfirstcomposeapp.R

@Composable
fun Progress(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .padding(16.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
        Spacer(Modifier.height(24.dp))
        LinearProgressIndicator()

    }
}

@Composable
fun ProgressAdvance(modifier: Modifier = Modifier) {

    Column(modifier = modifier
        .padding(16.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(
            progress = {0.5f}, // Es una funcion lamda que retorna un Float
        )
    }
}

@Composable
fun ProgressAdvance2(modifier: Modifier = Modifier) {
    var progress: Float by remember { mutableFloatStateOf(0.5f) }
    // mutableFloatStateOf es un estado que se puede modificar, y se usa para almacenar el progreso

    Column(modifier = modifier
        .padding(16.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(
            progress = {progress}, // Es una funcion lamda que retorna un Float
        )
        Row(modifier = Modifier.padding(16.dp)) {

            Button(onClick = { progress -= 0.1f }) {
                Text(text = "<-")
            }
            Spacer(Modifier.width(24.dp))
            Button(onClick = {  progress += 0.1f }) {
                Text(text = "->")
            }


        }
    }
}

@Composable
fun ProgressAnimarion(modifier: Modifier = Modifier) {

    val composition: LottieComposition?
    by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.progress1))

    Column(modifier = modifier
        .padding(16.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       LottieAnimation(composition = composition, iterations = LottieConstants.IterateForever)
    }
}

