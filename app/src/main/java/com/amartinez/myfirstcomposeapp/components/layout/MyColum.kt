package com.amartinez.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MyColumn(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Hola1", modifier = Modifier.background(Color.Yellow).weight(1f))
        Text("Hola2", modifier = Modifier.background(Color.Red).weight(1f))
        Text("Hola3",  modifier = Modifier.background(Color.Blue))
    }
}

@Preview(showBackground = true)
@Composable
fun MyColumn2(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        Text("Hola1", modifier = Modifier.background(Color.Yellow).weight(1f))
        Text("Hola2", modifier = Modifier.background(Color.Red).weight(1f))
        Text("Hola3",  modifier = Modifier.background(Color.Blue))
    }
}