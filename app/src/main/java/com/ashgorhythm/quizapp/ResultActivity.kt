package com.ashgorhythm.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val userName = intent.getStringExtra("name") ?: "Player"
            val score = intent.getIntExtra("score",0)
            Column(modifier = Modifier.fillMaxSize()
                .background(brush = Brush.verticalGradient(listOf(Color(0xFF6A3CFF),Color(0xFF9500FF)))),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally)

            {
                Spacer(modifier = Modifier.height(80.dp))
                Text(text = "Congratulation $userName",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White)
                Spacer(modifier = Modifier.size(15.dp))
                Image(painter = painterResource(R.drawable.trophy), contentDescription = "trophy",
                        modifier = Modifier.size(200.dp),
                    contentScale = ContentScale.Fit)
                Spacer(modifier = Modifier.size(15.dp))
                Text(text = "Your score is $score",
                    fontSize = 25.sp,
                    color = Color.White)
                Spacer(modifier = Modifier.size(15.dp))
                Button(onClick = {
                    Intent(this@ResultActivity, MainActivity::class.java).also {
                        it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(it)
                        finish()
                    }

                },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEFB8C8), contentColor = Color.Black))
                {
                    Text("Start Again",
                        fontWeight = FontWeight.Bold)
                }

            }
        }
    }
}
