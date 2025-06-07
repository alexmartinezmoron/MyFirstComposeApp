package com.amartinez.myfirstcomposeapp.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun MyState(modifier: Modifier = Modifier) {
    var number = remember { mutableStateOf(0) }

    Column {
        Text("Pulsame : ${number.value}", modifier = modifier.clickable { number.value +=1 })
        Text("Pulsame :", modifier = modifier.clickable { number.value +=1 })
    }
}

//Cuanto rotamos la pantalla muere el ciclo de vida de la actividad y se vuelve a crear por lo que se pierde el estado
//Para solucionar esto usamos el rememberSaveable
@Composable
fun MyStateSeveable(modifier: Modifier = Modifier) {
    var number = rememberSaveable { mutableStateOf(0) }

    Column {
        Text("Pulsame : ${number.value}", modifier = modifier.clickable { number.value +=1 })
        Text("Pulsame :", modifier = modifier.clickable { number.value +=1 })
    }
}

//Urilizamos el by para el valor del estado en una varible, si utilizaramos un val en lugar de bar
//no podriamos cambiar el valor de la variable por eso utilizamos var para importar el setter y getter
@Composable
fun MyStateSeveableBy(modifier: Modifier = Modifier) {
    var number by rememberSaveable { mutableStateOf(0) }
    Column {
        Text("Pulsame : ${number}", modifier = modifier.clickable { number +=1 })
        Text("Pulsame :", modifier = modifier.clickable { number +=1 })
    }
}