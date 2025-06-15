package com.amartinez.myfirstcomposeapp.components

import android.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun MyDropDownItem(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        DropdownMenuItem(
            text = { Text("Item 1") },
            onClick = { /* Handle item click */ },
            leadingIcon = {MyIcon()},
            trailingIcon = {MyIcon()}
        )

        Spacer(modifier = Modifier.weight(1f))
        DropdownMenuItem(
            text = { Text("Item 1") },
            onClick = { /* Handle item click */ },
            leadingIcon = { Icon(
                painter = painterResource(id = R.drawable.ic_delete),
                contentDescription = "Delete Icon"
            ) },
            trailingIcon = { Icon(
                painter = painterResource(id = R.drawable.ic_secure),
                contentDescription = "asdf"
            ) },
        )
    }
}