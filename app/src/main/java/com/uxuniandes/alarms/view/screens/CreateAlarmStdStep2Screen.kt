package com.uxuniandes.alarms.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.uxuniandes.alarms.R
import com.uxuniandes.alarms.view.fragments.AlarmInput
import com.uxuniandes.alarms.view.theme.AlarmTypography

@Composable
fun CreateAlarmStdStep2Screen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 52.dp),
        verticalArrangement = Arrangement.spacedBy(52.dp)
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.bell),
                contentDescription = stringResource(R.string.alarm),
                modifier = Modifier
                    .fillMaxWidth()
                    .width(233.dp)
                    .height(195.dp)
            )
        }
        item {
            Text(
                text = "Nombre de la alarma",
                color = MaterialTheme.colorScheme.primary,
                style = AlarmTypography.titleMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            AlarmInput("Nombre")
        }
        item {
            var showDialog by remember { mutableStateOf(false) }
            Button(
                onClick = { showDialog = true },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    "Crear Alarma",
                    style = AlarmTypography.labelLarge
                )
            }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = {
                        Text(
                            "Alarma Exitosa",
                            style = AlarmTypography.titleLarge,
                        )
                    },
                    text = {
                        Text(
                            "Alarma creada satisfactoriamente.",
                            style = AlarmTypography.bodyMedium,
                        )
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                showDialog = false
                                navController.navigate(AlarmAppScreen.Home.name)
                            }
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
    }
}

@Preview(showBackground = true)
@Composable
fun CreateAlarmStdStep2Preview() {
    CreateAlarmStdStep2Screen(rememberNavController())
}