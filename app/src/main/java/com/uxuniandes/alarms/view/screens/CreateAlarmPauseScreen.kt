package com.uxuniandes.alarms.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.uxuniandes.alarms.view.fragments.AlarmDropdown
import com.uxuniandes.alarms.view.fragments.InputNumber
import com.uxuniandes.alarms.view.theme.AlarmTypography

@Composable
fun CreateAlarmPauseScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 44.dp, start = 24.dp, end = 24.dp),
        verticalArrangement = Arrangement.spacedBy(44.dp)
    ) {
        item {
            Text(
                text = "Intervalo de tiempo en minutos",
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                style = AlarmTypography.titleSmall,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 22.dp)
            ) {
                InputNumber("20", "hora")
                Text(
                    text = ":",
                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp),
                    fontSize = 44.sp,
                    fontWeight = FontWeight.Bold
                )
                InputNumber("00", "minutos")
            }
        }

        item {
            HorizontalDivider()
        }
        item {
            Text(
                text = "Sonido de alarma",
                color = MaterialTheme.colorScheme.primary,
                style = AlarmTypography.titleSmall,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            AlarmDropdown(items = arrayOf("Jazz", "Music", "Other"))
        }
        item {
            Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = { navController.navigate(AlarmAppScreen.CreateAlarmPauseStep2.name) },
                ) {
                    Text(
                        "Siguiente",
                        style = AlarmTypography.labelLarge
                    )
                }
            }
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(0.dp)
                    .padding(bottom = 32.dp)
            )
        }
    }
}