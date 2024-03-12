package com.uxuniandes.alarms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.uxuniandes.alarms.view.screens.AlarmApp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlarmApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlarmPreview() {
    AlarmApp()
}