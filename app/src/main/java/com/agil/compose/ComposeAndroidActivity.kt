package com.agil.compose

import android.os.Bundle
import android.view.Gravity
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.agil.compose.core.*
import com.agil.compose.foundation.*

/**
 * 使用Android View + Compose Runtime，不使用Compose UI/Foundation/Material
 */
class ComposeAndroidActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            runComposeAndroid {
                var index by remember { mutableIntStateOf(1) }
                Column(
                    modifier = Modifier()
                        .gravity(Gravity.CENTER_HORIZONTAL)
                        .fillMaxSize()
                ) {
                    View(
                        modifier = Modifier()
                            .size(100, 100)
                            .backgroundColor("#ff0000")
                            .margin(20)
                    )
                    Text(
                        text = "Hello World",
                        modifier = Modifier()
                            .textSize(30)
                            .textColor("#00ff00")
                            .marginTop(20)
                            .marginLeft(20)
                    )
                    Text(
                        text = "测试文本2",
                        modifier = Modifier()
                            .textSize(20)
                            .textColor("#0000ff")
                            .margin(20)
                    )
                    Image(
                        source = R.drawable.ic_launcher_foreground,
                        modifier = Modifier()
                            .size(400, 400)
                            .padding(20),
                        tintColor = when(index) {
                            1 -> "#ff0000"
                            2 -> "#00ff00"
                            else -> "#0000ff"
                        }
                    )
                    Button("Button",
                        {
                            toast("click button")
                            index++
                            if (index > 3) {
                                index = 1
                            }
                        }
                    )
                    Row(
                        modifier = Modifier()
                            .gravity(Gravity.CENTER_VERTICAL)
                            .marginTop(50)
                    ) {
                        Text(
                            text = "Hello World",
                            modifier = Modifier()
                                .textSize(30)
                                .textColor("#00ff00")
                        )
                        Text(
                            text = "测试文本",
                            modifier = Modifier()
                                .textSize(20)
                                .textColor("#0000ff")
                                .marginLeft(20)
                        )
                        Image(
                            source = R.mipmap.ic_launcher,
                            modifier = Modifier()
                                .size(120, 120)
                                .marginLeft(20)
                        )
                        Counter()
                    }
                }
            }
        )
    }

    @Composable
    fun Counter() {
        var count by remember { mutableIntStateOf(0) }
        Button(
            text = "Count: $count",
            { count += 1 }
        )
    }

}