package com.uxuniandes.alarms.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uxuniandes.alarms.R
import com.uxuniandes.alarms.view.fragments.AlarmCheckbox
import com.uxuniandes.alarms.view.fragments.AlarmDatePicker
import com.uxuniandes.alarms.view.fragments.AlarmDropdown
import com.uxuniandes.alarms.view.fragments.AlarmTimePicker
import com.uxuniandes.alarms.view.fragments.CircleIcon
import com.uxuniandes.alarms.view.fragments.FilledCharButton
import com.uxuniandes.alarms.view.theme.AlarmTypography

@Composable
fun CreateAlarmStdScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 28.dp, start = 24.dp, end = 24.dp),
        verticalArrangement = Arrangement.spacedBy(28.dp)
    ) {
        item {
            Text(
                text = "Sugerencias de alarma",
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                style = AlarmTypography.titleLarge,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            val alarmList = stringArrayResource(R.array.alarms_suggest)
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                alarmList.forEach { el ->
                    ListItem(
                        headlineContent = {
                            Text(el, style = AlarmTypography.bodyMedium)
                        }, tonalElevation = 4.dp
                    )
                }
            }
        }
        item {
            Text(
                text = "Nueva Alarma",
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                style = AlarmTypography.titleLarge,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            AlarmTimePicker()
        }
        item {
            AlarmDatePicker()
        }
        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(vertical = 6.dp, horizontal = 18.dp)
                    .fillMaxWidth()
            ) {
                val days = listOf("D", "L", "M", "X", "J", "V", "S")
                days.forEach {
                    FilledCharButton(it)
                }
            }
        }
        item {
            Text(
                text = "Tono de notificación",
                color = MaterialTheme.colorScheme.primary,
                style = AlarmTypography.titleSmall,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            AlarmCheckbox("Sonido")
            AlarmCheckbox("Vibración")
            AlarmCheckbox("En pantalla")
        }
        item {
            Text(
                text = "Sonido Notificación",
                color = MaterialTheme.colorScheme.primary,
                style = AlarmTypography.titleSmall,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            AlarmDropdown(
                arrayOf(
                    "Última Canción de Spotify",
                    "Ringtone1",
                    "Ringtone2",
                    "Notification1",
                    "Notification2",
                    "Alarm1",
                    "Alarm2"
                )
            )
        }
        item {
            Text(
                text = "Vibración",
                color = MaterialTheme.colorScheme.primary,
                style = AlarmTypography.titleSmall,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            AlarmDropdown(
                arrayOf(
                    "Corto", "Intermitente", "Largo"
                )
            )
        }
        item {
            Text(
                text = "Notas",
                color = MaterialTheme.colorScheme.primary,
                style = AlarmTypography.titleSmall,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            var isFocused by remember { mutableStateOf(false) }
            var textState by remember { mutableStateOf(TextFieldValue()) }
            OutlinedTextField(value = textState,
                onValueChange = { textState = it },
                label = { Text("Notas") },
                minLines = if (isFocused) 4 else 1,
                modifier = Modifier
                    .onFocusChanged {
                        isFocused = it.isFocused
                    }
                    .fillMaxWidth(),
                singleLine = false,
                trailingIcon = {
                    IconButton(
                        onClick = { textState = TextFieldValue() }
                    ) {
                        CircleIcon(
                            icon = Icons.Default.Clear,
                            contentDescription = "Clear text",
                            backgroundColor = Color.Gray
                        )
                    }
                })
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

@Preview(showBackground = true)
@Composable
fun CreateAlarmStdPreview() {
    CreateAlarmStdScreen()
}