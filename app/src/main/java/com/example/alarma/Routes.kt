package com.example.alarma

sealed class Routes(val route: String) {
    object PantallaHome: Routes("App alarma")
    object PantallaCrearAlarma: Routes("Crear alarma")
    object PantallaCrearAlarmaPausa: Routes("Crear alarma pausa activa")
    object PantallaSuscripcion: Routes("Añadir suscripción")
    object PantallaListadoAlarmas: Routes("Ver listado de alarmas")
}