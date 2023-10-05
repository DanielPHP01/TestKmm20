package com.example.testkmm20.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.testkmm20.SharedCode
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // Вызываем функцию, которая аннотирована как @Composable
                MyComposable()
            }
        }
    }

    @Composable
    fun MyComposable() {
        var result by remember { mutableStateOf(0) }
        var input1 by remember { mutableStateOf("0") }
        var input2 by remember { mutableStateOf("0") }
        val calculator = SharedCode.Calculator()

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            BasicTextField(
                value = input1,
                onValueChange = {
                    input1 = it
                    val a = input1.toIntOrNull() ?: 0
                    val b = input2.toIntOrNull() ?: 0
                    // Обновление состояния result
                    result = calculator.addNumber(a, b)
                }
            )
            BasicTextField(
                value = input2,
                onValueChange = {
                    input2 = it
                    val a = input1.toIntOrNull() ?: 0
                    val b = input2.toIntOrNull() ?: 0
                    // Обновление состояния result
                    result = calculator.addNumber(a, b)
                }
            )
            Text("Result: $result")
        }
    }
}