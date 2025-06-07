package com.amartinez.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun MyTextField(modifier: Modifier) {
    Column(modifier = modifier) {
        var text by remember { mutableStateOf("") }
        TextField(value = text, onValueChange = { text = it })

    }
}
//Patent and child
@Composable
fun MyTextFieldParent(modifier: Modifier) {
    var user by remember { mutableStateOf("") }
    var value by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        MyTextFieldChild(user, onValueChange = { user = it })
        MyTextFieldChild2(value, onValueChange = { value = it })
        MyTextFieldChild3(value, onValueChange = { value = it })
    }
}

@Composable
fun MyTextFieldChild(user: String , onValueChange: (String) -> Unit) {
    TextField(value = user, onValueChange = { onValueChange(it) })
}
@Composable
fun MyTextFieldChild2(value: String , onValueChange: (String) -> Unit) {
    TextField(value = value, onValueChange = { onValueChange(it) }, label = {
        Text("Enter your name")
    })
}
@Composable
fun MyTextFieldChild3(value: String , onValueChange: (String) -> Unit) {
    TextField(value = value, onValueChange = { onValueChange(it) }, placeholder = {
        Text("Enter your pasword")
    })
}