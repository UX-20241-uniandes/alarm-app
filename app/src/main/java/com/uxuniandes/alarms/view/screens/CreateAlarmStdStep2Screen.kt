package com.uxuniandes.alarms.view.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.uxuniandes.alarms.view.fragments.ConfirmCreateAlarm

@Composable
fun CreateAlarmStdStep2Screen(navController: NavHostController) {
    ConfirmCreateAlarm(navController)
}

@Preview(showBackground = true)
@Composable
fun CreateAlarmStdStep2Preview() {
    CreateAlarmStdStep2Screen(rememberNavController())
}