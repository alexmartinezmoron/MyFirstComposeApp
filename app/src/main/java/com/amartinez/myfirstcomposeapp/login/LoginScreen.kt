package com.amartinez.myfirstcomposeapp.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name! federicosgsd" ,
        modifier = modifier
    )
}

@Preview
@Composable
fun ExamplePreviw() {
    Example("Alex")
}

@Composable
fun Example(a: String){
    Text("Hola $a",
        modifier = Modifier.padding(16.dp).background(Color.Yellow)
    )

}