package com.uxuniandes.alarms.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uxuniandes.alarms.R
import com.uxuniandes.alarms.view.fragments.AlarmInput
import com.uxuniandes.alarms.view.fragments.CircleIcon
import com.uxuniandes.alarms.view.theme.AlarmTypography

@Composable
fun AddSubscriptionScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.subscription),
                    contentDescription = "alarma",
                    modifier = Modifier
                        .width(280.dp)
                        .height(280.dp)
                )
            }
        }

        item {
            Text(
                text = "Ingresa código de suscripción",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 26.dp, vertical = 8.dp),
                style = AlarmTypography.titleMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
        }

        item {
            var textState by remember { mutableStateOf(TextFieldValue()) }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 26.dp, vertical = 8.dp)) {
                AlarmInput("Código de la suscripción")
            }
        }

        item {
            var showDialog by remember { mutableStateOf(false) }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 26.dp, vertical = 33.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { showDialog = true },
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text("Suscribirse",
                        style = AlarmTypography.labelLarge,)
                }

                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = { showDialog = false },
                        title = {
                            Text("Suscripción exitosa",
                                style = AlarmTypography.titleLarge,)
                        },
                        text = {
                            Text("Te has suscrito exitosamente a la lista “positiva” puedes desactivar o eliminar las alarmas cargadas cuando considere necesario.",
                                style = AlarmTypography.bodyMedium,)
                        },
                        dismissButton = {
                            TextButton(
                                onClick = { showDialog = false }
                            ) {
                                Text("Cancelar",
                                    style = AlarmTypography.labelMedium,)
                            }
                        },
                        confirmButton = {
                            TextButton(
                                onClick = { showDialog = false }
                            ) {
                                Text("Aceptar",
                                    style = AlarmTypography.labelMedium,)
                            }
                        }
                    )
                }
            }
        }

    }
}