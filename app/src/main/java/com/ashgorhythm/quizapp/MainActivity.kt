package com.ashgorhythm.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashgorhythm.quizapp.ui.theme.QuizAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main()
            }
        }
    }
@Preview(showSystemUi = true)
@Composable
fun Main(){
    var name by remember { mutableStateOf("")}

    Column(modifier = Modifier
        .fillMaxSize()
        .background(brush = Brush.verticalGradient(listOf(Color(0xFF6A3CFF),Color(0xFF9500FF)))),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = "Quiz",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFFFFF),
            letterSpacing = 5.sp)

        Spacer(modifier = Modifier.height(7.dp))
        Card(modifier = Modifier
            .padding(15.dp)
            .height(250.dp)
            .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp))
        {
             Column(modifier = Modifier
                 .fillMaxWidth()
                 .padding(15.dp),
                 horizontalAlignment = Alignment.CenterHorizontally)
             {
                 Text(text = "Welcome",
                     fontSize = 30.sp,
                     fontWeight = FontWeight.Bold)
                 Spacer(modifier = Modifier.height(25.dp))
                 Text(text = "Enter your name.",
                     fontSize = 22.sp,
                     color = Color.Gray
                 )

                 OutlinedTextField(value = name,
                     onValueChange = { name = it},
                     modifier = Modifier.padding(7.dp),
                     )
             }
        }




    }
}