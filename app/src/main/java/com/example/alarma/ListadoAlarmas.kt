package com.example.alarma

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp
import com.example.alarma.ui.theme.Typography

@Composable
fun PantallaListadoAlarmas(){

    var showEliminarModal by remember { mutableStateOf(false) }
    var showDesactivarModal by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 90.dp,
                start = 26.dp,
                end = 26.dp,
                bottom = 0.dp
            ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                text = "Hoy",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp),
                style = Typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }

        item {
            Column (
                modifier = Modifier
                    .fillMaxWidth(),) {

                ListItem(
                    headlineContent = {
                        Text(
                            "10:30 AM | Reunión con el jefe ",
                            style = Typography.bodyMedium,
                            ) },
                    supportingContent = {
                        Text(
                            "Alarma de suscripción XFWD"
                            ) },
                    trailingContent = {
                        Row(){
                            FloatingActionButton(
                                onClick = { showEliminarModal = true },
                                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                                modifier = Modifier.size(49.dp)
                            ) {
                                Icon(painter = painterResource(id = R.drawable.eliminar),
                                    "Eliminar",
                                    modifier = Modifier.size(27.dp))
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            FloatingActionButton(
                                onClick = { showDesactivarModal = true },
                                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                                modifier = Modifier.size(49.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.deshabilitar),
                                    "Deshabilitar",
                                    modifier = Modifier.size(27.dp))
                            }
                        }
                    }
                )

                HorizontalDivider()

                ListItem(
                    headlineContent = {
                        Text(
                            "11:30 AM | Reunión con el jefe",
                            style = Typography.bodyMedium,
                        ) },
                    trailingContent = {
                        Row(){
                            FloatingActionButton(
                                onClick = { showEliminarModal = true },
                                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                                modifier = Modifier.size(49.dp)
                            ) {
                                Icon(painter = painterResource(id = R.drawable.eliminar),
                                    "Eliminar",
                                    modifier = Modifier.size(27.dp))
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            FloatingActionButton(
                                onClick = { showDesactivarModal = true },
                                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                                modifier = Modifier.size(49.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.deshabilitar),
                                    "Deshabilitar",
                                    modifier = Modifier.size(27.dp))
                            }
                        }
                    }
                )

                HorizontalDivider()

                ListItem(
                    headlineContent = {
                        Text(
                            "13:00 AM | Almuerzo",
                            style = Typography.bodyMedium,
                        ) },
                    trailingContent = {
                        Row(){
                            FloatingActionButton(
                                onClick = { showEliminarModal = true },
                                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                                modifier = Modifier.size(49.dp)
                            ) {
                                Icon(painter = painterResource(id = R.drawable.eliminar),
                                    "Eliminar",
                                    modifier = Modifier.size(27.dp))
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            FloatingActionButton(
                                onClick = { showDesactivarModal = true },
                                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                                modifier = Modifier.size(49.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.deshabilitar),
                                    "Deshabilitar",
                                    modifier = Modifier.size(27.dp))
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
                style = Typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }

        item {
            Column (
                modifier = Modifier
                    .fillMaxWidth(),) {

                ListItem(
                    headlineContent = {
                        Text(
                            "10:30 AM | Reunión con el jefe ",
                            style = Typography.bodyMedium,
                        ) },
                    supportingContent = {
                        Text(
                            "Alarma de suscripción XFWD"
                        ) },
                    trailingContent = {
                        Row(){
                            FloatingActionButton(
                                onClick = { showEliminarModal = true },
                                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                                modifier = Modifier.size(49.dp)
                            ) {
                                Icon(painter = painterResource(id = R.drawable.eliminar),
                                    "Eliminar",
                                    modifier = Modifier.size(27.dp))
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            FloatingActionButton(
                                onClick = { showDesactivarModal = true },
                                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                                modifier = Modifier.size(49.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.deshabilitar),
                                    "Deshabilitar",
                                    modifier = Modifier.size(27.dp))
                            }
                        }
                    }
                )

                HorizontalDivider()

                ListItem(
                    headlineContent = {
                        Text(
                            "11:30 AM | Reunión con el jefe",
                            style = Typography.bodyMedium,
                        ) },
                    trailingContent = {
                        Row(){
                            FloatingActionButton(
                                onClick = { showEliminarModal = true },
                                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                                modifier = Modifier.size(49.dp)
                            ) {
                                Icon(painter = painterResource(id = R.drawable.eliminar),
                                    "Eliminar",
                                    modifier = Modifier.size(27.dp))
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            FloatingActionButton(
                                onClick = { showDesactivarModal = true },
                                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                                modifier = Modifier.size(49.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.deshabilitar),
                                    "Deshabilitar",
                                    modifier = Modifier.size(27.dp))
                            }
                        }
                    }
                )

                HorizontalDivider()

                ListItem(
                    headlineContent = {
                        Text(
                            "13:00 AM | Almuerzo",
                            style = Typography.bodyMedium,
                        ) },
                    trailingContent = {
                        Row(){
                            FloatingActionButton(
                                onClick = { showEliminarModal = true },
                                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                                modifier = Modifier.size(49.dp)
                            ) {
                                Icon(painter = painterResource(id = R.drawable.eliminar),
                                    "Eliminar",
                                    modifier = Modifier.size(27.dp))
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            FloatingActionButton(
                                onClick = { showDesactivarModal = true },
                                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                                modifier = Modifier.size(49.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.deshabilitar),
                                    "Deshabilitar",
                                    modifier = Modifier.size(27.dp))
                            }
                        }
                    }
                )

                HorizontalDivider()
            }
        }
    }

    if (showEliminarModal) {
        AlertDialog(
            onDismissRequest = { showEliminarModal = false },
            title = {
                Text("Eliminar Alarma",
                    style = Typography.titleLarge,)
            },
            text = {
                Text("¿Desea Eliminar la alarma?\n" +
                        "\n" +
                        "10:30 AM | Reunión con el jefe",
                    style = Typography.bodyMedium,)
            },
            dismissButton = {
                TextButton(
                    onClick = { showEliminarModal = false }
                ) {
                    Text("Cancelar",
                        style = Typography.labelMedium,)
                }
            },
            confirmButton = {
                TextButton(
                    onClick = { showEliminarModal = false }
                ) {
                    Text("Aceptar",
                        style = Typography.labelMedium,)
                }
            }
        )
    }

    if (showDesactivarModal) {
        AlertDialog(
            onDismissRequest = { showDesactivarModal = false },
            title = {
                Text("Desactivar Alarma",
                    style = Typography.titleLarge,)
            },
            text = {
                Text("¿Desea Eliminar la alarma?\n" +
                        "\n" +
                        "10:30 AM | Reunión con el jefe",
                    style = Typography.bodyMedium,)
            },
            dismissButton = {
                TextButton(
                    onClick = { showDesactivarModal = false }
                ) {
                    Text("Cancelar",
                        style = Typography.labelMedium,)
                }
            },
            confirmButton = {
                TextButton(
                    onClick = { showDesactivarModal = false }
                ) {
                    Text("Aceptar",
                        style = Typography.labelMedium,)
                }
            }
        )
    }
}