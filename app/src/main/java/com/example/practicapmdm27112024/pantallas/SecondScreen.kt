package com.example.navigation.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.navigation.navegacion.AppScreen
import com.example.practicapmdm27112024.componentes.botones.Boton
import com.example.practicapmdm27112024.componentes.card.CardString


@Composable
fun SecondScreen(
    modifier: Modifier, navController: NavController, nombre: String?, dni: String?, notas: Float?
) {
    SecondBody(modifier, navController, nombre, dni, notas)
}

@Composable
fun SecondBody(
    modifier: Modifier,
    navController: NavController,
    nombre: String?,
    dni: String?,
    notas: Float?
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //muestro la informacion que el navHost ha podido recoger de la pantalla principal
        CardString("Bienvenido \n   ¡¡¡$nombre!!!")
        CardString("se ha registrado correctamente con su dni:\n $dni")

        //si me viene una nota que es nula no puedo multiplicarla
        CardString(if (notas != null) { "su nota multiplicada: \n$notas X 2  = ${notas * 2f}" }else null)

        //este boton me permite navegar a la pantalla principal
        Boton(
            texto = "salir de la sesion",
            onClick = {
                navController.navigate(route = AppScreen.FirstScreen.route)
            },
            enabled = true
        )
    }
}
