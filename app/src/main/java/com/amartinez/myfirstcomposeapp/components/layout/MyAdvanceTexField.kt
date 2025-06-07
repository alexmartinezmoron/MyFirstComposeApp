package com.amartinez.myfirstcomposeapp.components.layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun MyAdvancedTextFieldParent(modifier: Modifier) {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        MyTextFieldUser(user, onValueChange = { user = it })
        MyTextFieldPassword(password, onValueChange = { password = it })
    }
}


@Composable
fun MyTextFieldUser(user: String, onValueChange: (String) -> Unit) {
    TextField(value = user,
        onValueChange = { onValueChange(it) },
        label = {
        Text("Enter your name")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}
@Composable
fun MyTextFieldPassword(password: String, onValueChange: (String) -> Unit) {

    var passwordVisible by remember { mutableStateOf(false) }

    TextField(value = password,
        onValueChange = { onValueChange(it) },
        placeholder = {
            Text("Enter your password")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            Text(if (passwordVisible) "🔒" else "👁️",
                Modifier.clickable { passwordVisible = !passwordVisible }
            )
        },
        visualTransformation =
        if (passwordVisible) VisualTransformation.None
        else PasswordVisualTransformation()
    )
}
