package com.example.izotov_jetpack_compose

import android.media.Image
import android.os.Bundle
import android.print.PrintAttributes
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin.Companion.Center
import androidx.compose.ui.text.PlaceholderVerticalAlign.Companion.Center
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.example.izotov_jetpack_compose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val myColor: Color = Color(0xFF60D394)
            val White1: Color = Color(0xFFFFFFFF)
            val checkedState = remember { mutableStateOf(false) }
            val checkedState1 = remember { mutableStateOf(false) }
            Izotov_Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = myColor
                ) {
                    Column (modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)) {
                        text()
                        row1()
                        row2()
                        Image()
                        Button()
                        BottomPanel()
                        }
                    }
                }
            }
        }
    }


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Izotov_Jetpack_ComposeTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun Button() {
    val White1: Color = Color(0xFFFFFFFF)
    Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFAAF683), contentColor = Color(
        0xFF366B1B
    )
    ), modifier = Modifier
        .size(350.dp, 60.dp)
        .offset(x = 12.dp, y = 345.dp)
        .background(color = Color(0xFF60D394)), shape = RoundedCornerShape(15.dp)) {
        Text("Добавить будильник",
            fontSize = 20.sp,
            color = White1)
    }
}

@Preview(showBackground = true)
@Composable
fun Image() {
    Image(
        painter = BitmapPainter(ImageBitmap.imageResource(R.drawable.avatar)),
        contentDescription = "аватар",
        modifier = Modifier
            .size(60.dp)
            .offset(x = 305.dp, y = -215.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun text() {
    val White1: Color = Color(0xFFFFFFFF)
    Text("Будильник",
        fontSize = 30.sp,
        modifier = Modifier.padding(20.dp),
        color = White1,
        fontWeight = FontWeight.Bold)
}

@Preview(showBackground = true)
@Composable
fun row1() {
    val myColor: Color = Color(0xFF60D394)
    val White1: Color = Color(0xFFFFFFFF)
    val checkedState = remember { mutableStateOf(false) }
    val checkedState1 = remember { mutableStateOf(false) }
    Row (verticalAlignment = Alignment.CenterVertically ) {
        PrintAttributes.Margins(40, 0, 0, 0)
        Text("07:30",
            fontSize = 60.sp,
            modifier = Modifier.padding(5.dp),
            color = White1,
            fontWeight = FontWeight.Light)
        Switch(
            checked = checkedState.value,
            onCheckedChange = {
                checkedState.value = it
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color(0xFFFFFFFF),
                checkedTrackColor = Color(0xFFAAF683),
                uncheckedThumbColor = Color(0xFFFFFFFF),
                uncheckedTrackColor = Color(0xFFFF9B85)
            ),
            modifier = Modifier
                .size(90.dp, 45.dp)
                .offset(x = 125.dp, y = 5.dp)
                .background(
                    color = (if (checkedState.value) {
                        Color(0xFFAAF683)
                    } else {
                        Color(0xFFFF9B85)
                    }), shape = RoundedCornerShape(25.dp)
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun row2() {
    val myColor: Color = Color(0xFF60D394)
    val White1: Color = Color(0xFFFFFFFF)
    val checkedState = remember { mutableStateOf(false) }
    val checkedState1 = remember { mutableStateOf(false) }
    Row (verticalAlignment = Alignment.CenterVertically ) {
        Text("08:00",
            fontSize = 60.sp,
            modifier = Modifier.padding(5.dp),
            color = White1,
            fontWeight = FontWeight.Light)
        Switch(
            checked = checkedState1.value,
            onCheckedChange = {
                checkedState1.value = it
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color(0xFFFFFFFF),
                checkedTrackColor = Color(0xFFAAF683),
                uncheckedThumbColor = Color(0xFFFFFFFF),
                uncheckedTrackColor = Color(0xFFFF9B85)
            ),
            modifier = Modifier
                .size(90.dp, 45.dp)
                .offset(x = 125.dp, y = 5.dp)
                .background(
                    color = (if (checkedState1.value) {
                        Color(0xFFAAF683)
                    } else {
                        Color(0xFFFF9B85)
                    }), shape = RoundedCornerShape(25.dp)
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SwitcherView() {
    var checkedState by remember {
        mutableStateOf(true)
    }
    Switch(
        checked = checkedState, onCheckedChange = { checkedState = it },
        modifier = Modifier
            .background(color = Color(0xFFAAF683), shape = RoundedCornerShape(15.dp))
            .size(60.dp, 35.dp),
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color(0xFFFFFFFF),
            checkedTrackColor = Color(0xFFAAF683),
            uncheckedThumbColor = Color(0xFFFFFFFF),
            uncheckedTrackColor = Color(0xFFFF0000)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun BottomPanel() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center).offset(y = 390.dp)) {
        Box(modifier = Modifier
            .size(320.dp, 80.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp,
                )
            ).background(LightGreen),
        ){
            Row(modifier = Modifier.padding(all = 8.dp)) {
                Column (modifier = Modifier.padding(start = 24.dp, top = 8.dp)) {
                    Image(
                        painter = painterResource(R.drawable.image),
                        contentDescription = "List",
                        modifier = Modifier
                            .size(40.dp)
                            .clickable ( onClick = { Log.d("p", "pressed") } )
                    )
                    Text(
                        text = "List",
                        color = Red1,
                        modifier = Modifier
                            .width(40.dp)
                            .wrapContentSize(Alignment.Center),
                        fontSize = 10.sp
                    )
                }
                Column (modifier = Modifier.padding(start = 32.dp, top = 8.dp)) {
                    Image(
                        painter = painterResource(R.drawable.image1),
                        contentDescription = "Alarm",
                        modifier = Modifier
                            .size(40.dp)
                            .clickable ( onClick = { Log.d("p", "pressed1") } )
                    )
                    Text(
                        text = "Red",
                        color = Green1,
                        modifier = Modifier
                            .width(40.dp)
                            .wrapContentSize(Alignment.Center),
                        fontSize = 10.sp
                    )
                }
                Column (modifier = Modifier.padding(start = 32.dp, top = 8.dp)) {
                    Image(
                        painter = painterResource(R.drawable.image2),
                        contentDescription = "List",
                        modifier = Modifier
                            .size(40.dp)
                            .clickable ( onClick = { Log.d("p", "pressed2") } )
                    )
                    Text(
                        text = "Calendar",
                        color = Red1,
                        modifier = Modifier
                            .width(40.dp)
                            .wrapContentSize(Alignment.Center),
                        fontSize = 10.sp
                    )
                }
                Column (modifier = Modifier.padding(start = 32.dp, top = 8.dp)) {
                    Image(
                        painter = painterResource(R.drawable.image3),
                        contentDescription = "Settings",
                        modifier = Modifier
                            .size(40.dp)
                            .clickable ( onClick = { Log.d("p", "pressed3") } )
                    )
                    Text(
                        text = "Red",
                        color = Red1,
                        modifier = Modifier
                            .width(40.dp)
                            .wrapContentSize(Alignment.Center),
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}



