package com.uxuniandes.alarms.view.screens


import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.uxuniandes.alarms.R
import com.uxuniandes.alarms.view.theme.AlarmTypography

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    var isExpanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
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
                        text = stringResource(R.string.pause_alarm_text),
                        modifier = Modifier.padding(horizontal = 16.dp),
                        style = AlarmTypography.titleLarge,
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
                        painter = painterResource(id = R.drawable.welcome),
                        contentDescription = stringResource(R.string.alarm),
                        modifier = Modifier
                            .width(280.dp)
                            .height(228.dp)
                    )
                }

            }

            item {
                Text(
                    text = stringResource(R.string.pause_alarm_lead),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 56.dp),
                    style = AlarmTypography.bodyMedium,
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
                        onClick = { navController.navigate(AlarmAppScreen.CreateAlarmPause.name) },
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(
                            stringResource(R.string.create_alarm_to_pause),
                            style = AlarmTypography.labelLarge
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
                    text = stringResource(R.string.day_alarms),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 26.dp),
                    textAlign = TextAlign.Center,
                    style = AlarmTypography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            item {
                val alarmList = stringArrayResource(R.array.alarms)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                ) {
                    alarmList.forEach { el ->
                        ListItem(
                            headlineContent = {
                                Text(el, style = AlarmTypography.bodyMedium)
                            }
                        )
                        HorizontalDivider()
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
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {

        CustomFloatingActionButton(
            expandable = true,
            onFabClick = { isExpanded = !isExpanded },
            fabIcon = Icons.Default.Add,
            navController = navController
        )
    }
}


@Composable
fun CustomFloatingActionButton(
    expandable: Boolean,
    onFabClick: () -> Unit,
    fabIcon: ImageVector,
    navController: NavHostController
) {
    var isExpanded by remember { mutableStateOf(false) }

    val fabSize = 120.dp
    val expandedFabWidth by animateDpAsState(
        targetValue = if (isExpanded) 360.dp else fabSize,
        animationSpec = spring(dampingRatio = 3f)
    )
    val expandedFabHeight by animateDpAsState(
        targetValue = if (isExpanded) 160.dp else fabSize,
        animationSpec = spring(dampingRatio = 3f)
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Box(
            modifier = Modifier
                .offset(y = (-16).dp)
                .size(
                    width = expandedFabWidth,
                    height = (animateDpAsState(if (isExpanded) 300.dp else 0.dp, animationSpec = spring(dampingRatio = 4f))).value)

        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                FloatingActionButton(
                    onClick = { navController.navigate(AlarmAppScreen.CreateAlarmStd.name) }
                ) {
                    Text(
                        text = stringResource(R.string.create_alarm_pause_title),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 26.dp),
                        textAlign = TextAlign.Center,
                        style = AlarmTypography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                FloatingActionButton(
                    onClick = { navController.navigate(AlarmAppScreen.CreateAlarmPause.name) }
                ) {
                    Text(
                        text = stringResource(R.string.create_alarm_std_title),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 26.dp),
                        textAlign = TextAlign.Center,
                        style = AlarmTypography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )

                }
            }
        }

        FloatingActionButton(
            onClick = {
                onFabClick()
                if (expandable) {
                    isExpanded = !isExpanded
                }
            },
            modifier = Modifier
                .width(expandedFabWidth)
                .height(expandedFabHeight)
                .padding(16.dp),
            shape = CircleShape
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = fabIcon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(48.dp)
                )
                if (isExpanded) {
                    Text(
                        text = "Crear",
                        style = AlarmTypography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}










