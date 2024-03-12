package com.uxuniandes.alarms.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.uxuniandes.alarms.R
import com.uxuniandes.alarms.view.theme.AlarmTypography

@Composable
fun AlarmListScreen() {

    var showDeleteModal by remember { mutableStateOf(false) }
    var showDeactivateModal by remember { mutableStateOf(false) }
    val alarmList = stringArrayResource(R.array.alarms_with_subs)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 12.dp
            ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                text = "Hoy",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp),
                style = AlarmTypography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }

        items(alarmList) { alarm ->

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ListItem(
                    headlineContent = {
                        Text(
                            alarm.split(';')[0],
                            style = AlarmTypography.bodyMedium,
                        )
                    },
                    supportingContent = {
                        if (alarm.contains(';')) {
                            Text(
                                alarm.split(';')[1],
                                style = AlarmTypography.labelSmall,
                            )
                        }
                    },
                    trailingContent = {
                        Row{
                            FloatingActionButton(
                                onClick = { showDeleteModal = true },
                                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                                containerColor = MaterialTheme.colorScheme.tertiary,
                                modifier = Modifier.size(49.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.delete),
                                    contentDescription = stringResource(R.string.delete),
                                    modifier = Modifier.size(27.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            FloatingActionButton(
                                onClick = { showDeactivateModal = true },
                                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                                containerColor = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(49.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.block),
                                    contentDescription = stringResource(R.string.disable),
                                    modifier = Modifier.size(27.dp)
                                )
                            }
                        }
                    }
                )

                HorizontalDivider()
            }
        }

        item {
            HorizontalDivider(
                modifier = Modifier
                    .padding(vertical = 26.dp)
                    .height(4.dp),
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.primary
            )
        }

        item {
            Text(
                text = "26 de febrero",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp),
                style = AlarmTypography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }

        items(alarmList) { alarm ->

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ListItem(
                    headlineContent = {
                        Text(
                            alarm.split(';')[0],
                            style = AlarmTypography.bodyMedium,
                        )
                    },
                    supportingContent = {
                        if (alarm.contains(';')) {
                            Text(
                                alarm.split(';')[1],
                                style = AlarmTypography.labelSmall,
                            )
                        }
                    },
                    trailingContent = {
                        Row{
                            FloatingActionButton(
                                onClick = { showDeleteModal = true },
                                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                                containerColor = MaterialTheme.colorScheme.tertiary,
                                modifier = Modifier.size(49.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.delete),
                                    contentDescription = stringResource(R.string.delete),
                                    modifier = Modifier.size(27.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            FloatingActionButton(
                                onClick = { showDeactivateModal = true },
                                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                                containerColor = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(49.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.block),
                                    contentDescription = stringResource(R.string.disable),
                                    modifier = Modifier.size(27.dp)
                                )
                            }
                        }
                    }
                )

                HorizontalDivider()
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

    if (showDeleteModal) {
        AlertDialog(
            onDismissRequest = { showDeleteModal = false },
            title = {
                Text(
                    stringResource(R.string.delete_alarm),
                    style = AlarmTypography.titleLarge,
                )
            },
            text = {
                Text(
                    "¿Desea Eliminar la alarma?\n" +
                            "\n" +
                            "10:30 AM | Reunión con el jefe",
                    style = AlarmTypography.bodyMedium,
                )
            },
            dismissButton = {
                TextButton(
                    onClick = { showDeleteModal = false }
                ) {
                    Text(
                        "Cancelar",
                        style = AlarmTypography.labelMedium,
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = { showDeleteModal = false }
                ) {
                    Text(
                        "Aceptar",
                        style = AlarmTypography.labelMedium,
                    )
                }
            }
        )
    }

    if (showDeactivateModal) {
        AlertDialog(
            onDismissRequest = { showDeactivateModal = false },
            title = {
                Text(
                    "Desactivar Alarma",
                    style = AlarmTypography.titleLarge,
                )
            },
            text = {
                Text(
                    "¿Desea Eliminar la alarma?\n" +
                            "\n" +
                            "10:30 AM | Reunión con el jefe",
                    style = AlarmTypography.bodyMedium,
                )
            },
            dismissButton = {
                TextButton(
                    onClick = { showDeactivateModal = false }
                ) {
                    Text(
                        "Cancelar",
                        style = AlarmTypography.labelMedium,
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = { showDeactivateModal = false }
                ) {
                    Text(
                        "Aceptar",
                        style = AlarmTypography.labelMedium,
                    )
                }
            }
        )
    }
}