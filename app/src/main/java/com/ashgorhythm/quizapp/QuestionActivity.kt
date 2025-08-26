package com.ashgorhythm.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashgorhythm.quizapp.model.Question
import com.ashgorhythm.quizapp.model.Questions

class QuestionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Q()
        }

    }
}
@Preview(showSystemUi = true)
@Composable
fun Q(){
    val questionList = Questions.getQuestions()
    var selectedOption by remember { mutableStateOf<String?>(null) }
    var showResult by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(brush = Brush.verticalGradient(listOf(Color(0xFF6A3CFF),Color(0xFF9500FF)))),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Spacer(modifier = Modifier.size(120.dp))
        Text(text = "${questionList[0].question}",
            fontSize = 30.sp,
            color = Color.White)
        Spacer(modifier = Modifier.size(10.dp))
        Image(painter = painterResource(R.drawable.bangladesh),
            contentDescription = "BD flag",
            modifier = Modifier.size(170.dp))
        Card(modifier = Modifier
            .padding(15.dp)
            .height(250.dp)
            .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp))
        {
            Column(modifier = Modifier.padding(16.dp))
            {
               questionList[0].options.forEach { option ->
                   OptionButton(
                       name = option,
                       option = questionList[0],
                       isSelected = (selectedOption == option),
                       showResult = false,
                       onClick = {
                            if (!showResult){
                                selectedOption = option
                            }
                       })
               }

            }

        }
        Spacer(modifier = Modifier.size(15.dp))
        if (!showResult) {
            Button(
                onClick = { showResult = true },
                enabled = selectedOption != null,
                modifier = Modifier.width(150.dp)
            ) {
                Text("Submit Answer")
            }
        } else {
            Button(
                onClick = {
                    selectedOption = null
                    showResult = false
                },
                modifier = Modifier.width(150.dp)
            ) {
                Text("Next Question")
            }
        }



    }
}

@Composable
fun OptionButton(
    name: String ,
    option: Question,
    isSelected: Boolean,
    showResult: Boolean,
    onClick: ()  -> Unit
) {
    val backgroundColor = when {
        showResult && option.options.indexOf(name) == option.correctAnswer -> Color.Green.copy(alpha = 0.2f)
        showResult && option.options.indexOf(name) != option.correctAnswer && isSelected -> Color.Red.copy(0.2f)
        isSelected -> MaterialTheme.colorScheme.primary.copy(0.2f)
        else -> Color.Transparent
    }
    val borderColor = when {
        showResult && option.options.indexOf(name) == option.correctAnswer -> Color.Green
        showResult && option.options.indexOf(name) != option.correctAnswer && isSelected -> Color.Red
        isSelected -> MaterialTheme.colorScheme.primary
        else -> Color.Gray
    }

    Card(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
            colors = CardDefaults.cardColors(containerColor = backgroundColor),
            border = BorderStroke(2.dp,borderColor)
    )
    {
        Text(text = name,
            modifier = Modifier.padding(12.dp),
            fontSize = 18.sp)
    }
    }


