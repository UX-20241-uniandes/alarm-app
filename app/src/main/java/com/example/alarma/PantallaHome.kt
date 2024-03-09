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
import com.example.alarma.ui.theme.Typography

@Composable
fun PantallaHome(){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 100.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Alarma pausa activa",
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
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
                    modifier = Modifier.width(280.dp).height(280.dp)
                )
            }

        }

        item {
            Text(
                text = "Crea tu alarma para mantenerte en movimiento",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 56.dp, vertical = 8.dp),
                style = Typography.bodyMedium,
                textAlign = TextAlign.Center
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 26.dp, vertical = 33.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {  },
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text("Crear alarma para pausa activa",
                        style = Typography.labelLarge,)
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
                    .padding(horizontal = 26.dp, vertical = 33.dp),
                textAlign = TextAlign.Center,
                style = Typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }

        item {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 26.dp),) {
                ListItem(
                    headlineContent = { Text("12:30 | Almuerzo ") },
                    supportingContent = { Text("Secondary text") },
                )

                HorizontalDivider()

                ListItem(
                    headlineContent = { Text("15:00 | Gimnasio ") },
                )

                HorizontalDivider()
            }
        }
    }

}

