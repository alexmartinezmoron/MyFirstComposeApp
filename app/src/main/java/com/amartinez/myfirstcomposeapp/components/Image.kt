package com.amartinez.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.amartinez.myfirstcomposeapp.R

@Composable
fun MyImage(modifier: Modifier) {
  Image(painter = painterResource(id = R.drawable.andalucia),
      contentDescription = "Mi imagen",
      modifier = modifier.size(2000.dp),
      contentScale = ContentScale.Crop
  )
}

@Composable
fun MyImageClip(modifier: Modifier) {
    Image(painter = painterResource(id = R.drawable.andalucia),
        contentDescription = "Mi imagen",
        modifier = modifier
            .size(300.dp)
            .clip(CircleShape)
            .border(5.dp, Color.Blue, shape = CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MyImageClipAndGradient(modifier: Modifier) {
    Image(painter = painterResource(id = R.drawable.andalucia),
        contentDescription = "Mi imagen",
        modifier = modifier
            .size(300.dp)
            .clip(CircleShape)
            .border(5.dp, shape = CircleShape, brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Blue, Color.Yellow))),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MyNetworkImage(modifier: Modifier) {
    AsyncImage(model = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Fronalpstock_big.jpg/800px-Fronalpstock_big.jpg",
        contentDescription = "Imagen de internet",
        modifier = modifier
            .size(300.dp)
            .clip(CircleShape)
            .border(5.dp, Color.Blue, shape = CircleShape),
        onError = {
            Log.i("Alex", "Ha ocurrido un error al cargar la imagen: ${it.result.throwable.message}")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MyIcon(){
    Icon(
        painter = painterResource(id = R.drawable.ic_personita),
        contentDescription = "Icono de la app",
        modifier = Modifier.size(100.dp),
        tint = Color.Blue
    )
}
