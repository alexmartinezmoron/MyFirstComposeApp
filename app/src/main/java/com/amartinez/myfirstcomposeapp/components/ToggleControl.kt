package com.amartinez.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.amartinez.myfirstcomposeapp.components.state.CheckBoxState

@Composable
fun MySwitch(modifier: Modifier = Modifier) {
    var switchState by rememberSaveable { mutableStateOf(true) }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Switch(switchState, onCheckedChange = { switchState = it })
    }
}


@Composable
fun MySwitch2(modifier: Modifier = Modifier) {
    var switchState by rememberSaveable { mutableStateOf(true) }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Switch(
            checked = switchState, // Estado del switch
            onCheckedChange = { switchState = it }, // Cambia el estado del switch al hacer click
            thumbContent = { MyIcon() }, // Pasamo un composable como contenido del thumb
            enabled = false // Deshabilita el switch
        )

    }
}

@Composable
fun MyCheckBox(modifier: Modifier = Modifier) {
    var boxState by rememberSaveable { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Checkbox(checked = boxState, onCheckedChange = { boxState = it })
    }
}

@Composable
fun MyCheckBox2(modifier: Modifier = Modifier) {
    var boxState by rememberSaveable { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Checkbox(
            checked = boxState,
            onCheckedChange = { boxState = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red, // Color del checkbox cuando está seleccionado
                checkmarkColor = Color.Blue, // Color de la marca de verificación
                uncheckedColor = Color.Blue, // Color del checkbox cuando no está seleccionado
                disabledCheckedColor = Color.Red, // Color del checkbox cuando está deshabilitado
                disabledUncheckedColor = Color.Red // Color de la marca de verificación

            )
        )
    }
}

@Composable
fun MyCheckBox3(modifier: Modifier = Modifier) {
    var boxState by rememberSaveable { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { boxState = !boxState }) {
            Checkbox(checked = boxState, onCheckedChange = { boxState = it })
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = "Acepto los terminos y condiciones")
        }
    }

}

// Composable totalmente reutilizable que recibe un CheckBoxState y una función onCheckedChange
@Composable
fun CheckBoxWithText(
    modifier: Modifier = Modifier,
    checkBoxState: CheckBoxState,
    onCheckedChange: (CheckBoxState) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onCheckedChange(checkBoxState) }) {
        Checkbox(
            checked = checkBoxState.isChecked, onCheckedChange = { onCheckedChange(checkBoxState) })
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = checkBoxState.label)
    }
}

// Composable que contiene varios CheckBox, cada uno con su propio estado
@Composable
fun ParentCheckBoxes(modifier: Modifier = Modifier) {
    val checkBoxState1 = CheckBoxState(id = "1", label = "Opción 1")
    val checkBoxState2 = CheckBoxState(id = "2", label = "Opción 2")
    val checkBoxState3 = CheckBoxState(id = "3", label = "Opción 3")

    var checkBoxStates by rememberSaveable {
        mutableStateOf(listOf(checkBoxState1, checkBoxState2, checkBoxState3))
    }

    Column(modifier = modifier.fillMaxSize()) {
        checkBoxStates.forEach { checkBoxState ->
            CheckBoxWithText(
                checkBoxState = checkBoxState, onCheckedChange = { updatedState ->
                    checkBoxStates = checkBoxStates.map {
                        if (it.id == updatedState.id) {
                            it.copy(isChecked = !it.isChecked)
                        } else {
                            it
                        }
                    }
                })
        }
    }
}

//Composable con 3 estados
@Composable
fun TriStateCheckBox(modifier: Modifier = Modifier) {
    var parentState by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    var child1 by rememberSaveable { mutableStateOf(false) }
    var child2 by rememberSaveable { mutableStateOf(false) }

    // LaunchedEffect se usa para observar cambios en child1 y child2
    LaunchedEffect(child1, child2) {
        parentState = when {
            child1 && child2 -> ToggleableState.On
            !child1 && !child2 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }

    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(parentState, onClick = {
                val newState = parentState != ToggleableState.On
                child1 = newState
                child2 = child1
            })
            Text(text = "Seleccionar todos")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(checked = child1, onCheckedChange = { child1 = it })
            Text(text = "Ejemplo 1")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(checked = child2, onCheckedChange = { child2 = it })
            Text(text = "Ejemplo 2")
        }
    }
}

@Composable
fun MyRadioButton(modifier: Modifier = Modifier) {
    var selected by rememberSaveable { mutableStateOf(false) }
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = selected,
            onClick = { selected = !selected }
        )
        Text(text = "Ejemplo de RadioButton")
    }
}

@Composable
fun MyRadioButtonList(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        var selectedName by rememberSaveable { mutableStateOf("") }

        MyRadioButtonComponent(
            name = "Opción 1",
            seletedName = selectedName,
            onItemSelected = { selectedName = it }
        )
        MyRadioButtonComponent(
            name = "Opción 2",
            seletedName = selectedName,
            onItemSelected = { selectedName = it }
        )
        MyRadioButtonComponent(
            name = "Opción 3",
            seletedName = selectedName,
            onItemSelected = { selectedName = it }
        )
    }
}

@Composable
fun MyRadioButtonComponent(name: String, seletedName: String, onItemSelected: (String) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = name == seletedName,
            onClick = { onItemSelected(name) }
        )
        Text(text = name)
    }
}
