package com.amartinez.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amartinez.myfirstcomposeapp.ui.theme.Pink40
import com.amartinez.myfirstcomposeapp.ui.theme.Pink80

@Preview
@Composable
fun MyComplexLayout(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Box(modifier = Modifier.weight(1f).fillMaxWidth().background(Color.Cyan), contentAlignment = Alignment.Center) {
            Text("Ejemplo 1")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.weight(1f).fillMaxWidth().background(Color.Red)) {
            Row(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Ejemplo 2")
                }
                Spacer(modifier = Modifier.width(20.dp))
                Column(
                    modifier = Modifier.weight(1f).fillMaxHeight().background(Color.Green),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Ejemplo 3")
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.weight(1f).fillMaxWidth().background(Pink80), contentAlignment = Alignment.BottomCenter) {
            Text("Ejemplo 4")
        }
    }
}