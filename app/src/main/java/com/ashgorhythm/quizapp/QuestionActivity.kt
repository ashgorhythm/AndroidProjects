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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
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
import androidx.compose.ui.node.Ref
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
        Spacer(modifier = Modifier.size(10.dp))
        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            LinearProgressIndicator(
            progress = {0.4f} ,
            trackColor = Color.DarkGray,
            color = Color.Green
        )
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = "4/10",
                fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.size(10.dp))
        Card(modifier = Modifier
            .padding(15.dp)
            .height(250.dp)
            .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp))
        {
            Column(modifier = Modifier.padding(16.dp))
            {
                OptionButton()

            }

        }
        Spacer(modifier = Modifier.size(10.dp))
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(Color(0xFFC31DFF), Color.White),
            elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 10.dp))
        {
            Text("Next Question")
        }
    }
}

@Composable
fun OptionButton(
)
{
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Green.copy(0.1f)),
        border = BorderStroke(2.dp, Color.Green.copy(0.2f))

    )
    {
        Text(text = "Option",
            modifier = Modifier.padding(12.dp),
            fontSize = 18.sp)
    }
}




