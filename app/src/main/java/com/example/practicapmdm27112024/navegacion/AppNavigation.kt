package com.example.navigation.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation.pantallas.FirstScreen
import com.example.navigation.pantallas.SecondScreen


//metodo elegio el navigation
//he utilizado el navHost por que me parece mas comodo al centralizar todas las pantallas en una sola funcion
//me parece mas practico y ordenado que utilizar le indent que tiene a mas fallos
@Composable
fun AppNavigation(modifier: Modifier) {

    //instancio un objeto de tipo NavHostController, donde guarda el estado de la navegacion
    val navControlador = rememberNavController()

    //configuro el navHost
    NavHost(

        //donde le digo que instancia tiene que usar de navegacion usar
        navController = navControlador,

        //la primera ruta que debe cargar
        startDestination = AppScreen.FirstScreen.route) {
        composable(AppScreen.FirstScreen.route) {
            FirstScreen(modifier, navControlador)
        }

        //creo la url que debe cargar juntos con los datos que se van a pasar a la navegacion de la segunda pantalla
        composable(
            AppScreen.SecondScreen.route + "/{nombre}/{dni}/{nota}",
            // lo bueno que si los datos que recoge en la pntalla principal no son correctos, el propio navHost me da un error, y yo lo puedo recoger facilmente :D
            //entonces el navHost me da mas seguridad al comprobar que el tipo de dato es el correcto y el que yo quiero
            arguments = listOf(
                //creo una lista de un String String y un Float
                navArgument(name = "nombre") {
                    type = NavType.StringType
                },
                navArgument(name = "dni") {
                    type = NavType.StringType
                },
                navArgument(name = "nota") {
                    type = NavType.FloatType
                }
            ),

            ) {

            SecondScreen(

                //le paso por parametros todos los datos que el nav haya podido recoger
                modifier,
                navControlador,
                it.arguments?.getString("nombre"),
                it.arguments?.getString("dni"),
                it.arguments?.getFloat("nota")
            )
        }
    }
}