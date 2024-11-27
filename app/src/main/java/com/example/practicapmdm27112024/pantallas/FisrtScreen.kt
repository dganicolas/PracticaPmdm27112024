package com.example.navigation.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.navigation.navegacion.AppScreen
import com.example.practicapmdm27112024.componentes.botones.Boton
import com.example.practicapmdm27112024.componentes.camposTextos.EditText

@Composable
fun FirstScreen(modifier: Modifier, navController: NavController) {
    FirstBody(modifier, navController)
}


@Composable

fun FirstBody(
    modifier: Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //creo las variables para que se pueda usar en la app
        var textoNombre by remember { mutableStateOf("") }
        var textoDni by remember { mutableStateOf("") }
        var textoNotas by remember { mutableStateOf("") }

        //este es un campo de texto de nombre
        EditText(
            texto = "Dime tu nombre",
            textoEjemplo = "ej:Nicolas",
            textoEditText = textoNombre,
            onValueChange = { textoNombre = it },

            //si el texto esta vacio o con espacio activo el modo error
            error = textoNombre.isBlank()
        )

        //este es un campo de texto de dni
        EditText(
            texto = "Dime tu Dni",
            textoEditText = textoDni,
            textoEjemplo = "ej:12345678Z",

            //pongo la letra en mayuscula siempre
            onValueChange = { textoDni = it.toUpperCase() },

            //si el dni no es de 9 de largo y con una letra la final activo el modo error
            error = !(textoDni.length == 9 &&
                    textoDni.last().digitToIntOrNull() == null)
        )

        //este es un campo de texto de notas
        EditText(
            texto = "Dime tus notas",
            textoEditText = textoNotas,
            textoEjemplo = "ej:5.4",

            //reemplazo el carater por si acaso el usuario, me mete una coma en vez de punto
            onValueChange = { textoNotas = it.replace(",", ".") },

            //si el texto no se puede convertir a float activo el modo error
            error = textoNotas.toFloatOrNull() == null
        )

        //este es un boton que me permite llevar los datos a la pantalla segunda
        Boton(
            texto = "enviar datos", onClick = {
                navController.navigate(route = AppScreen.SecondScreen.route + "/" + textoNombre + "/" + textoDni + "/" + textoNotas.toFloat())
            }, enabled =
            //aqui compruebo o valido todos los parametros que me entran, para poder pasara a la otra pantalla
            if (

            //compruebo que el nombre no este vacio
                textoNombre != "" &&

                //compruebo que contenga 8 de largo
                textoDni.length == 9 &&

                //aqui compruiebo que la ultima letra del dni sea una letra
                textoDni.last().digitToIntOrNull() == null &&

                //compruebo si puedo convertir el textoNotas a float
                textoNotas.toFloatOrNull() != null
            ) true
            else false
        )
    }
}

