package com.example.listpesertaquiz3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listpesertaquiz3.ui.theme.ListPesertaQuiz3Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListPesertaQuiz3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    textStyle: TextStyle = TextStyle(),
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .background(color)

    ) {
        Text(
            text = symbol,
            style = textStyle,
            fontSize = 36.sp,
            color = Color.White
        )
    }
}

//CalculatorButton(
//symbol = "7",
//color = MediumGray,
//modifier = Modifier
//.aspectRatio(1f)
//.weight(1f)
//) {
//    viewModel.onAction(CalculatorAction.Number(7))
//}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name.trim().substring(0,1),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListPesertaQuiz3Theme {
        Greeting("Android")
        CalculatorButton(
            symbol = "prapta".trim().substring(0,1),
//            color = Purple80,
            modifier = Modifier
//                .aspectRatio(1f)
                .height(100.dp)
                .width(150.dp)
        ) {

        }
    }
}


//https://github.com/philipplackner/CalculatorPrep/blob/master/app/src/main/java/com/plcoding/calculatorprep/MainActivity.kt
