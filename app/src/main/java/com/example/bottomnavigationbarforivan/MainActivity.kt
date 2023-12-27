package com.example.bottomnavigationbarforivan

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottomnavigationbarforivan.ui.theme.BottomNavigationBarForIvanTheme

class MainActivity : ComponentActivity() {


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationBarForIvanTheme {
                var name by remember { mutableStateOf(">>click buttons<<") }

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(onButtonClick = {
                            name = it
                        })
                    }
                ) {
                    Text(
                        fontSize = 30.sp,
                        text = "Hello $name!"
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(onButtonClick: (String) -> Unit) {
    val boxHeight = 90.dp
    val circleRadius = boxHeight * 0.9f / 2

    Box(
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxWidth()
            .height(boxHeight)
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .fillMaxWidth()
                .align(Alignment.BottomEnd),
        ) {
            Button(
                shape = RoundedCornerShape(20.dp, 0.dp, 0.dp, 0.dp),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                onClick = {
                    onButtonClick("History")
                }
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(end = 20.dp)
                ){
                    Icon(Icons.Filled.DateRange, contentDescription = null)
                    Text(
                        fontSize = 13.sp,
                        text = "Event history"
                    )
                }
            }

            Button(
                shape = RoundedCornerShape(0.dp, 20.dp, 0.dp, 0.dp),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                onClick = {
                    onButtonClick("Profile")
                }
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(start = 30.dp)
                ){
                    Icon(Icons.Filled.AccountCircle, contentDescription = null)
                    Text(
                        fontSize = 13.sp,
                        text = "Profile"
                    )
                }
            }
        }

        Button(
            shape = CircleShape,
            border = BorderStroke(1.dp, Color.White),
            modifier = Modifier
                .size(circleRadius * 2)
                .align(Alignment.TopCenter),
            onClick = {
                onButtonClick("Events")
            }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                 Icon(Icons.Filled.Star, contentDescription = null)
                 Text(
                     fontSize = 10.sp,
                     text = "Events"
                 )
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(
    showSystemUi = true,
)
@Composable
fun Preview() {
    BottomNavigationBarForIvanTheme {
        var name by remember { mutableStateOf(">>click buttons<<") }

        Scaffold(
            bottomBar = {
                BottomNavigationBar(onButtonClick = {
                    name = it
                })
            }
        ) {
            Text(
                fontSize = 30.sp,
                text = "Hello $name!"
            )
        }
    }
}