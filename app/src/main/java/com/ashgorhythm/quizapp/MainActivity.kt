package com.ashgorhythm.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
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
                            label = {Text("Name")},
                            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Person") }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = {
                            if (!name.isEmpty()){
                                Intent(this@MainActivity, QuestionActivity::class.java).also {
                                    it.putExtra("name",name)
                                    startActivity(it)
                                }
                            } else {
                                Toast.makeText(this@MainActivity,"Please enter a name", Toast.LENGTH_SHORT).show()
                            }
                        },
                            modifier = Modifier.width(120.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = Color(0xFF9500FF))
                        )
                        {
                            Text(text = "Submit",
                                fontSize = 17.sp)
                        }
                    }
                }




            }
            }
        }
    }
