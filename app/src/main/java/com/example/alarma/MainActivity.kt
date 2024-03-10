@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.alarma

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.*
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.alarma.ui.theme.AlarmaTheme
import kotlinx.coroutines.launch

import com.example.alarma.ui.theme.Typography


@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val title = remember { mutableStateOf("Home") }
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            val scope = rememberCoroutineScope()
            val navigationController = rememberNavController()

            val navBackStackEntry by navigationController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            title.value = currentRoute ?: "Home"

            navigationController.addOnDestinationChangedListener { _, destination, _ ->
                title.value = destination.route ?: "Home"
            }

            AlarmaTheme {
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            Text("Menú",
                                modifier = Modifier.padding(16.dp),
                                style = Typography.titleLarge,)
                            HorizontalDivider()
                            NavigationDrawerItem(
                                label = { Text(text = "Home") },
                                selected = false,
                                onClick = {
                                    navigationController.navigate(Routes.PantallaHome.route)
                                    scope.launch { drawerState.close() }
                                }
                            )
                            HorizontalDivider()
                            NavigationDrawerItem(
                                label = { Text(text = "Crear alarma") },
                                selected = false,
                                onClick = {
                                    navigationController.navigate(Routes.PantallaCrearAlarma.route)
                                    scope.launch { drawerState.close() }
                                }
                            )
                            HorizontalDivider()
                            NavigationDrawerItem(
                                label = { Text(text = "Crear alarma pausa activa") },
                                selected = false,
                                onClick = {
                                    navigationController.navigate(Routes.PantallaCrearAlarmaPausa.route)
                                    scope.launch { drawerState.close() }
                                }
                            )
                            HorizontalDivider()
                            NavigationDrawerItem(
                                label = { Text(text = "Añadir suscripción") },
                                selected = false,
                                onClick = {
                                    navigationController.navigate(Routes.PantallaSuscripcion.route)
                                    scope.launch { drawerState.close() }
                                }
                            )
                            HorizontalDivider()
                            NavigationDrawerItem(
                                label = { Text(text = "Ver listado de alarmas") },
                                selected = false,
                                onClick = {
                                    navigationController.navigate(Routes.PantallaListadoAlarmas.route)
                                    scope.launch { drawerState.close() }
                                }
                            )
                        }
                    },
                ) {
                    Scaffold(
                        topBar = {
                            TopBar(title = title.value) {
                                scope.launch {
                                    drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            }
                        }
                    ) { contentPadding ->
                        NavHost(
                            navController = navigationController,
                            startDestination = Routes.PantallaHome.route
                        ) {
                            composable(Routes.PantallaHome.route) {
                                PantallaHome(navigationController)
                            }
                            composable(Routes.PantallaCrearAlarma.route) {
                                PantallaCrearAlarma()
                            }
                            composable(Routes.PantallaCrearAlarmaPausa.route) {
                                PantallaCrearAlarmaPausa()
                            }
                            composable(Routes.PantallaSuscripcion.route) {
                                PantallaSuscripcion()
                            }
                            composable(Routes.PantallaListadoAlarmas.route) {
                                PantallaListadoAlarmas()
                            }
                        }
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PantallaSuscripcion()
}
