package com.uxuniandes.alarms.view.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.uxuniandes.alarms.R
import com.uxuniandes.alarms.view.screens.AlarmAppScreen
import com.uxuniandes.alarms.view.theme.AlarmTypography
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun FilledCharButton(letter: String) {
    var checked by remember { mutableStateOf(false) }

    FilledIconToggleButton(
        checked = checked, onCheckedChange = { checked = it }, colors = IconToggleButtonColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
            contentColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
            checkedContainerColor = MaterialTheme.colorScheme.tertiary,
            checkedContentColor = MaterialTheme.colorScheme.onTertiary
        ), modifier = Modifier.size(30.dp)
    ) {
        Text(text = letter.uppercase(), style = AlarmTypography.labelLarge)
    }
}


@Composable
fun CircleIcon(
    icon: ImageVector,
    contentDescription: String?,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    iconColor: Color = Color.Gray,
    iconSize: Dp = 24.dp,
    strokeWidth: Dp = 2.dp,
) {
    Box(
        modifier = modifier.size(iconSize)
    ) {
        Box(modifier = Modifier
            .size(iconSize)
            .drawBehind {
                drawCircle(
                    color = backgroundColor, style = Stroke(width = strokeWidth.toPx())
                )
            })
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = iconColor,
            modifier = Modifier.size(iconSize)
        )
    }
}

@Composable
fun AlarmTimePicker() {
    var textState by remember { mutableStateOf(TextFieldValue()) }
    var showTimePicker by remember { mutableStateOf(false) }
    val formatter = remember { SimpleDateFormat("hh:mm a", Locale.getDefault()) }
    val state = rememberTimePickerState()
    OutlinedTextField(value = textState,
        onValueChange = { textState = it },
        label = { Text("Hora") },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("hh:mm a") },
        leadingIcon = {
            IconButton(onClick = { showTimePicker = true }) {
                Icon(
                    painter = painterResource(R.drawable.clock),
                    contentDescription = "Localized description"
                )
            }
        })

    if (showTimePicker) {
        TimePickerDialog(
            onCancel = { showTimePicker = true },
            onConfirm = {
                val cal = Calendar.getInstance()
                cal.set(Calendar.HOUR_OF_DAY, state.hour)
                cal.set(Calendar.MINUTE, state.minute)
                cal.isLenient = false
                textState = TextFieldValue(formatter.format(cal.time))
                showTimePicker = false
            },
        ) {
            TimePicker(state = state)
        }
    }
}

@Composable
fun AlarmDatePicker() {
    var textState by remember { mutableStateOf(TextFieldValue()) }
    val openDialog = remember { mutableStateOf(false) }

    OutlinedTextField(value = textState,
        onValueChange = { textState = it },
        label = { Text("Fecha") },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("MM/DD/YYYY") },
        trailingIcon = {
            IconButton(onClick = { openDialog.value = true }) {
                Icon(Icons.Outlined.DateRange, contentDescription = "Localized description")
            }
        })

    if (openDialog.value) {
        val datePickerState by remember { mutableStateOf(DatePickerState(locale = Locale.UK)) }
        val confirmEnabled = remember {
            derivedStateOf { datePickerState.selectedDateMillis != null }
        }
        DatePickerDialog(onDismissRequest = {}, confirmButton = {
            TextButton(
                onClick = {
                    openDialog.value = false
                    val dateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.UK)
                    val formattedDate = datePickerState.selectedDateMillis?.let {
                        Date(
                            it + (1000 * 60 * 60 * 5)
                        )
                    }?.let { dateFormat.format(it) }
                    textState = formattedDate?.let { TextFieldValue(it) }!!
                }, enabled = confirmEnabled.value
            ) {
                Text("Aceptar")
            }
        }, modifier = Modifier
            .fillMaxSize()
            .background(Color(0x80000000))
        ) {
            DatePicker(state = datePickerState)
        }
    }
}

@Composable
fun TimePickerDialog(
    title: String = "Select Time",
    onCancel: () -> Unit,
    onConfirm: () -> Unit,
    toggle: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = onCancel,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Box(
            modifier = Modifier
                .background(Color(0x80000000))
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {

            Surface(
                shape = MaterialTheme.shapes.extraLarge,
                tonalElevation = 6.dp,
                modifier = Modifier
                    .width(IntrinsicSize.Min)
                    .height(IntrinsicSize.Min)
                    .background(
                        shape = MaterialTheme.shapes.extraLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    ),
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp),
                        text = title,
                        style = MaterialTheme.typography.labelMedium
                    )
                    content()
                    Row(
                        modifier = Modifier
                            .height(40.dp)
                            .fillMaxWidth()
                    ) {
                        toggle()
                        Spacer(modifier = Modifier.weight(1f))
                        TextButton(
                            onClick = onCancel
                        ) { Text("Cancel") }
                        TextButton(
                            onClick = onConfirm
                        ) { Text("OK") }
                    }
                }
            }
        }
    }
}

@Composable
fun AlarmCheckbox(text: String) {
    val (checkedState, onStateChange) = remember { mutableStateOf(true) }
    Row(
        Modifier
            .fillMaxWidth()
            .height(50.dp)
            .toggleable(
                value = checkedState,
                onValueChange = { onStateChange(!checkedState) },
                role = Role.Checkbox
            )
            .padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkedState, onCheckedChange = null
        )
        Text(
            text = text,
            style = AlarmTypography.bodyMedium,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun AlarmDropdown(items: Array<String>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(items[0]) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = it },
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                items.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun AlarmInput(label: String) {
    var textState by remember { mutableStateOf(TextFieldValue()) }
    OutlinedTextField(
        value = textState,
        onValueChange = { textState = it },
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = {
            if (textState.text.isNotEmpty()) {
                IconButton(onClick = { textState = TextFieldValue() }) {
                    CircleIcon(
                        icon = Icons.Default.Clear,
                        contentDescription = "Clear text",
                        backgroundColor = Color.Gray
                    )
                }
            }
        }
    )
}

@Composable
fun InputNumber(value: String, label: String) {
    var textState by remember { mutableStateOf(TextFieldValue(value)) }
    val pattern = remember { Regex("^\\d{2}$") }
    Column(modifier = Modifier.width(96.dp)) {
        OutlinedTextField(
            value = textState,
            onValueChange = {
                val tt = it.text
                if (tt.isEmpty() || tt.matches(pattern)) {
                    textState = it
                }
            },
            supportingText = { Text(text = label) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = TextStyle(
                fontSize = 45.sp,
                textAlign = TextAlign.Center
            ),
            colors = OutlinedTextFieldDefaults.colors().copy(
                focusedContainerColor = MaterialTheme.colorScheme.primaryContainer
            )
        )
    }
}

@Composable
fun ConfirmCreateAlarm(navController: NavController) {
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