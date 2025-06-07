package com.amartinez.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyButtons(modifier: Modifier) {
    Column (modifier = modifier.padding(10.dp) ){

        Button(onClick = { Log.i("Alex", "Boton Pulsado")}) {
            Text("Pulsame")
        }

        OutlinedButton(onClick = { Log.i("Alex", "Boton Outlined pulsado") }) {
            Text("Pulsame Outlined")
        }

        TextButton(onClick = { Log.i("Alex", "Boton Text pulsado") }) {
            Text("Cancelar")
        }

        ElevatedButton(onClick = { Log.i("Alex", "Boton Elevated pulsado") }) {
            Text("Pulsame Elevated")
        }

        FilledTonalButton(onClick = { Log.i("Alex", "Boton FilledTonalButton pulsado") }) {
            Text("Pulsame FilledTonalButton")
        }
    }
}