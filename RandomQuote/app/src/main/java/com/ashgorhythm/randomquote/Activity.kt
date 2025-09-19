package com.ashgorhythm.randomquote

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ashgorhythm.randomquote.quote.ImageScreen
import com.ashgorhythm.randomquote.quote.QuoteScreen
import com.ashgorhythm.randomquote.ui.theme.MyApplicationTheme

class Activity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize())
                 {
                     val navController = rememberNavController()
                     NavHost(
                         navController = navController,
                         startDestination = "quote"
                     ) {
                         composable("quote"){
                             QuoteScreen(navController)
                         }
                         composable("image"){
                             ImageScreen(navController)
                         }
                     }
                }

            }
        }
    }
}


