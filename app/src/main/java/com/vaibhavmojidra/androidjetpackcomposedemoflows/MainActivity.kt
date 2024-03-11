package com.vaibhavmojidra.androidjetpackcomposedemoflows

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.sp
import com.vaibhavmojidra.androidjetpackcomposedemoflows.ui.theme.AndroidJetpackComposeDemoFlowsTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MainActivity : ComponentActivity() {

    private val myFlow= flow<Int> {
        for (i in 1..100){
            emit(i)
            delay(1000L)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val currentValue=myFlow.collectAsState(initial = 1).value
            AndroidJetpackComposeDemoFlowsTheme {
                Text(text="Value is $currentValue", fontSize = 24.sp)
            }
        }
    }
}