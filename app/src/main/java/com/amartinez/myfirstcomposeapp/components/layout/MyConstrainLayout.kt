package com.amartinez.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun MyBasicConstrainLayout(modifier: Modifier = Modifier) {

   ConstraintLayout(modifier = modifier.fillMaxSize()) {
      val (redBox, grayBox, greenBox, magentaBox, yellowBox) = createRefs()
      Box(modifier.size(150.dp).background(Color.Red).constrainAs(redBox){
         top.linkTo(yellowBox.bottom)
         start.linkTo(yellowBox.end)
      })
      Box(modifier.size(150.dp).background(Color.Gray).constrainAs(grayBox){
         top.linkTo(yellowBox.bottom)
         end.linkTo(yellowBox.start)

      })
      Box(modifier.size(150.dp).background(Color.Green).constrainAs(greenBox){
         bottom.linkTo(yellowBox.top)
         start.linkTo(yellowBox.end)
      })
      Box(modifier.size(150.dp).background(Color.Magenta).constrainAs(magentaBox){
         bottom.linkTo(yellowBox.top)
         end.linkTo(yellowBox.start)
      })
      Box(modifier.size(150.dp).background(Color.Yellow).constrainAs(yellowBox){
         bottom.linkTo(parent.bottom)
         end.linkTo(parent.end)
         top.linkTo(parent.top)
         start.linkTo(parent.start)
      })
   }
}

//Ejemplo de uso de guias
@Preview
@Composable
fun ConstrainLayoutGuide(modifier: Modifier = Modifier) {
   ConstraintLayout(modifier = modifier.fillMaxSize()) {
      val topGuide = createGuidelineFromTop(0.1f)
      val (redBox) = createRefs()

      Box(Modifier.size(150.dp).background(Color.Red).constrainAs(redBox){
         top.linkTo(topGuide)
         //start.linkTo(parent.start)
      })
   }
}
//Ejemplo de uso de barreras
@Preview
@Composable
fun ConstrainLayoutBarrier(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
       val (redBox, greenBox, yellowBox) = createRefs()
        val barrier = createEndBarrier(redBox, greenBox)
        Box(modifier.size(150.dp).background(Color.Red).constrainAs(redBox){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        })
        Box(modifier.size(80.dp).background(Color.Green).constrainAs(greenBox){
            top.linkTo(redBox.bottom, margin = 16.dp)
            start.linkTo(parent.start, margin = 100.dp)

        })
        Box(modifier.size(150.dp).background(Color.Yellow).constrainAs(yellowBox){
            start.linkTo(barrier)
        })

    }
}

//Ejemplo de uso de cadenas
@Preview
@Composable
fun ConstrainLayoutChain(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (redBox, greenBox, yellowBox) = createRefs()
       //createHorizontalChain(redBox, greenBox, yellowBox, chainStyle =  ChainStyle.Spread)
       //createHorizontalChain(redBox, greenBox, yellowBox, chainStyle =  ChainStyle.Packed)
       createHorizontalChain(redBox, greenBox, yellowBox, chainStyle =  ChainStyle.SpreadInside)
        Box(modifier.size(100.dp).background(Color.Red).constrainAs(redBox){
           top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Box(modifier.size(100.dp).background(Color.Green).constrainAs(greenBox){
           start.linkTo(parent.start)
           end.linkTo(parent.end)
        })
        Box(modifier.size(100.dp).background(Color.Yellow).constrainAs(yellowBox){
           start.linkTo(parent.start)
           end.linkTo(parent.end)
        })
    }
}
