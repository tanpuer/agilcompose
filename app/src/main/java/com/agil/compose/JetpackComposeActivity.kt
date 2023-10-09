package com.agil.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

/**
 * 正版Jetpack Compose
 */
class JetpackComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var count by remember { mutableIntStateOf(0) }

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Color.Red)
                ) {}
                Text(
                    text = "Hello World",
                    modifier = Modifier.padding(20.dp),
                    color = Color.Green,
                    fontSize = TextUnit(30f, TextUnitType.Sp)
                )
                Text(
                    text = "测试文本2",
                    modifier = Modifier.padding(20.dp),
                    color = Color.Red,
                    fontSize = TextUnit(30f, TextUnitType.Sp)
                )
                Button(
                    onClick = { count++ },
                    modifier = Modifier.padding(bottom = 16.dp),
                ) {
                    Text(text = "Click me")
                }
                Text(text = "Count: $count")
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Hello World",
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp),
                        color = Color.Green,
                        fontSize = TextUnit(30f, TextUnitType.Sp)
                    )
                    Text(
                        text = "测试文本2",
                        modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp),
                        color = Color.Red,
                        fontSize = TextUnit(30f, TextUnitType.Sp)
                    )
                }
            }
        }
    }
}