package com.amartinez.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MySlider(modifier: Modifier = Modifier) {
    var myValue by rememberSaveable { mutableFloatStateOf(0f) }

    Column(modifier = modifier.padding(horizontal = 16.dp))
    {
        Slider(value = myValue, onValueChange = { myValue = it })
        Text(myValue.toString())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySliderAdvance(modifier: Modifier = Modifier) {
    var example by rememberSaveable { mutableStateOf(":(") }
    var state = remember { SliderState(
        value = 0.5f, // Initial value
        valueRange = 0f..10f, // Range of values
        steps = 9, // Number of steps between min and max
        onValueChangeFinished = {example = ":)" } // Callback when value change is finished
    ) }
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        Slider(
            state = state,
            //thumb = {}, es la barra que se mueve se puede personalizar
            //track = {} es la barra que se queda fija se puede personalizar
        )
        Text("Current value: ${state.value}" + " " + example)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider(modifier: Modifier = Modifier) {

    var state = remember { RangeSliderState()}
    Column(modifier = modifier.padding(horizontal = 50.dp)) {
        RangeSlider(state)
        Text("Current values: ${state.activeRangeStart} - ${state.activeRangeEnd}")
        Text(String.format("Range: %.1f - %.1f", state.activeRangeStart, state.activeRangeEnd))
    }


}