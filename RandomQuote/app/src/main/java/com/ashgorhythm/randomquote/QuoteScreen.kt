package com.ashgorhythm.randomquote

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response


@Composable
fun QuoteScreen(){
    var quote by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            try {
               val response = RetrofitInstance.quoteApi.getQuote()
               val firstQuote = response.body()?.firstOrNull()
                if (firstQuote != null){
                    quote = firstQuote.q
                    author = firstQuote.a
                }
            }catch (e: Exception){
                quote = "Error fetching quote"
                author = ""
            } finally {
                loading = false
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "Quote",
                fontSize = 50.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Magenta,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(vertical = 100.dp))
            if (loading){
                CircularProgressIndicator()
            }
            else {
                Text(
                    text = quote,
                    fontSize = 40.sp,
                    fontFamily = FontFamily.Monospace,
                    color = Color.White
                )
                Text(
                    text = author,
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Monospace,
                    color = Color.LightGray
                )
            }

            Spacer(modifier = Modifier.padding(vertical = 200.dp))
            Button(onClick = {
                loading = true
                scope.launch {
                    try {
                        val response = RetrofitInstance.quoteApi.getQuote()
                        val firstQuote = response.body()?.firstOrNull()
                        if (firstQuote != null){
                            quote = firstQuote.q
                            author = firstQuote.a
                        }
                    }catch (e: Exception){
                        quote = "Error fetching quote"
                        author = ""
                    } finally {
                        loading = false
                    }
                }
            }
            ) {
                Text("Next")
            }
        }
    }

}

