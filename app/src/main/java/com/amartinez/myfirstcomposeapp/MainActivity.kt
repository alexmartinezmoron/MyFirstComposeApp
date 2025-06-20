package com.amartinez.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.amartinez.myfirstcomposeapp.components.MyButtons
import com.amartinez.myfirstcomposeapp.components.MyCheckBox
import com.amartinez.myfirstcomposeapp.components.MyCheckBox3
import com.amartinez.myfirstcomposeapp.components.MyDropDownItem
import com.amartinez.myfirstcomposeapp.components.MyImage
import com.amartinez.myfirstcomposeapp.components.MyImageClip
import com.amartinez.myfirstcomposeapp.components.MyImageClipAndGradient
import com.amartinez.myfirstcomposeapp.components.MyNetworkImage
import com.amartinez.myfirstcomposeapp.components.MyRadioButton
import com.amartinez.myfirstcomposeapp.components.MyRadioButtonList
import com.amartinez.myfirstcomposeapp.components.MyRangeSlider
import com.amartinez.myfirstcomposeapp.components.MySlider
import com.amartinez.myfirstcomposeapp.components.MySliderAdvance
import com.amartinez.myfirstcomposeapp.components.MySwitch
import com.amartinez.myfirstcomposeapp.components.MySwitch2
import com.amartinez.myfirstcomposeapp.components.ParentCheckBoxes
import com.amartinez.myfirstcomposeapp.components.Progress
import com.amartinez.myfirstcomposeapp.components.ProgressAdvance
import com.amartinez.myfirstcomposeapp.components.ProgressAdvance2
import com.amartinez.myfirstcomposeapp.components.ProgressAnimarion
import com.amartinez.myfirstcomposeapp.components.TriStateCheckBox
import com.amartinez.myfirstcomposeapp.login.Greeting
import com.amartinez.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyDropDownItem(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstComposeAppTheme {
        Greeting("Android2")
    }
}