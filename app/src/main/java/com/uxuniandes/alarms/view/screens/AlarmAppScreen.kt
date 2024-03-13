package com.uxuniandes.alarms.view.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.uxuniandes.alarms.R
import com.uxuniandes.alarms.view.theme.AlarmsTheme
import com.uxuniandes.alarms.view.theme.AlarmTypography
import kotlinx.coroutines.launch

enum class AlarmAppScreen(@StringRes val title: Int) {
    Home(title = R.string.home_title),
    CreateAlarmStd(title = R.string.create_alarm_std_title),
    CreateAlarmStdStep2(title = R.string.create_alarm_std_title),
    CreateAlarmPause(title = R.string.create_alarm_pause_title),
    AddSubscription(title = R.string.add_subscription_title),
    AlarmList(title = R.string.alarm_list_title)
}

@Composable
fun AlarmAppBar(
    title: Int?,
    navigateUp: () -> Unit,
    onclickDrawable: () -> Unit,
    modifier: Modifier = Modifier
) {
    val canNavigateBack: Boolean =
        title == R.string.create_alarm_pause_title || title == R.string.create_alarm_std_title
    TopAppBar(title = { title?.let { Text(stringResource(it), style = AlarmTypography.bodyMedium) } },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        navigationIcon = {

            if (canNavigateBack) {
                IconButton(onClick = navigateUp, modifier.testTag("back_button")) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            } else {
                IconButton(onClick = { onclickDrawable() }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        })
}


@Composable
fun AlarmApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val activeRouteName = backStackEntry?.destination?.route ?: AlarmAppScreen.Home.name
    var screenTitle: Int? = null
    try {
        val selectedScreen = AlarmAppScreen.valueOf(activeRouteName)
        screenTitle = selectedScreen.title
    } catch (_: IllegalArgumentException) {
    }

    AlarmsTheme {

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    Text(
                        "Menú",
                        modifier = Modifier.padding(16.dp),
                        style = AlarmTypography.titleLarge,
                    )
                    HorizontalDivider()
                    NavigationDrawerItem(label = { Text(text = stringResource(R.string.home_title)) },
                        selected = false,
                        onClick = {
                            navController.navigate(AlarmAppScreen.Home.name)
                            scope.launch { drawerState.close() }
                        })
                    HorizontalDivider()
                    NavigationDrawerItem(label = { Text(text = stringResource(R.string.create_alarm_std_title)) },
                        selected = false,
                        onClick = {
                            navController.navigate(AlarmAppScreen.CreateAlarmStd.name)
                            scope.launch { drawerState.close() }
                        })
                    HorizontalDivider()
                    NavigationDrawerItem(label = { Text(text = stringResource(R.string.create_alarm_pause_title)) },
                        selected = false,
                        onClick = {
                            navController.navigate(AlarmAppScreen.CreateAlarmPause.name)
                            scope.launch { drawerState.close() }
                        })
                    HorizontalDivider()
                    NavigationDrawerItem(label = { Text(text = stringResource(R.string.add_subscription_title)) },
                        selected = false,
                        onClick = {
                            navController.navigate(AlarmAppScreen.AddSubscription.name)
                            scope.launch { drawerState.close() }
                        })
                    HorizontalDivider()
                    NavigationDrawerItem(label = { Text(text = stringResource(R.string.alarm_list_title)) },
                        selected = false,
                        onClick = {
                            navController.navigate(AlarmAppScreen.AlarmList.name)
                            scope.launch { drawerState.close() }
                        })
                }
            },
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
            ) {
                Scaffold(topBar = {
                    AlarmAppBar(title = screenTitle,
                        navigateUp = { navController.navigateUp() },
                        {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        })
                }) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = AlarmAppScreen.Home.name,
                        modifier = modifier.padding(innerPadding)
                    ) {
                        composable(AlarmAppScreen.Home.name) {
                            HomeScreen(navController)
                        }
                        composable(AlarmAppScreen.CreateAlarmStd.name) {
                            CreateAlarmStdScreen(navController)
                        }
                        composable(AlarmAppScreen.CreateAlarmStdStep2.name) {
                            CreateAlarmStdStep2Screen(navController)
                        }
                        composable(AlarmAppScreen.CreateAlarmPause.name) {
                            CreateAlarmPauseScreen()
                        }
                        composable(AlarmAppScreen.AlarmList.name) {
                            AlarmListScreen()
                        }
                        composable(AlarmAppScreen.AddSubscription.name) {
                            AddSubscriptionScreen()
                        }
                    }
                }
            }
        }
    }
}