package com.ashgorhythm.randomquote.quote

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest.Builder

@Composable
fun ImageScreen(navController: NavHostController){
    val context = LocalContext.current
    var reloadKey by remember { mutableStateOf(System.currentTimeMillis()) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            val painter = rememberAsyncImagePainter(
                Builder(LocalContext.current).data(
                data = "https://zenquotes.io/api/image?time=$reloadKey"
            ).apply(block = { -> crossfade(1000) }).build())
            val painterState = painter.state
            Image(
                painter = painter,
                contentDescription = "Quote"
            )
            if (painterState is AsyncImagePainter.State.Loading){
                CircularProgressIndicator()
            }
            Spacer(modifier = Modifier.size(50.dp))
            Button(onClick = { reloadKey = System.currentTimeMillis() }) {
                Text("New Quote")
            }
            Spacer(modifier = Modifier.size(50.dp))
            Button(onClick = {
                navController.popBackStack()
            }) {
                Text("Go Back")
            }
        }
    }
}