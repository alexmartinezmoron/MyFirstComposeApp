package com.amartinez.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun MyRow() {
    Row {
        Text("Hola1", modifier = Modifier.background(Color.Yellow).weight(1f))
        Text("Hola2", modifier = Modifier.background(Color.Red).weight(1f))
        Text("Hola3",  modifier = Modifier.background(Color.Blue))
    }
}