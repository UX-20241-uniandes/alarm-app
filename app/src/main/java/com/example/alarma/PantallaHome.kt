package com.example.alarma

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
import androidx.compose.material.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.alarma.ui.theme.Typography

import com.example.alarma.ui.theme.AlarmaTheme


@Composable
fun PantallaHome(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 64.dp
            ),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Alarma pausa activa",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = Typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        item {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.relojhome),
                    contentDescription = "alarma",
                    modifier = Modifier
                        .width(280.dp)
                        .height(228.dp)
                )
            }

        }

        item {
            Text(
                text = "Crea tu alarma para mantenerte en movimiento",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 56.dp),
                style = Typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 26.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { navController.navigate(Routes.PantallaCrearAlarma.route) },
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(
                        "Crear alarma para pausa activa",
                        style = Typography.labelLarge
                    )
                }
            }
        }

        item {
            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        item {
            Text(
                text = "Alarmas del día",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 26.dp),
                textAlign = TextAlign.Center,
                style = Typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                ListItem(
                    headlineContent = {
                        Text("12:30 | Almuerzo", style = Typography.bodyMedium)
                    }
                )

                HorizontalDivider()

                ListItem(
                    headlineContent = { Text("15:00 | Gimnasio", style = Typography.bodyMedium) },
                )

                HorizontalDivider()

                ListItem(
                    headlineContent = { Text("16:30 | Cena", style = Typography.bodyMedium) }
                )

                HorizontalDivider()

                ListItem(
                    headlineContent = {
                        Text(
                            "18:30 | Regar las plantas",
                            style = Typography.bodyMedium
                        )
                    }
                )

                HorizontalDivider()

                ListItem(
                    headlineContent = { Text("19:00 | Meditación", style = Typography.bodyMedium) }
                )

                HorizontalDivider()

                ListItem(
                    headlineContent = { Text("20:00 | Dormir", style = Typography.bodyMedium) }
                )

                HorizontalDivider()

            }
        }
        item {
            Box(modifier = Modifier.fillMaxWidth().height(0.dp).padding(bottom = 32.dp))
        }
    }

}

