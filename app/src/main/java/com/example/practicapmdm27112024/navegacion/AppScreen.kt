package com.example.navigation.navegacion

//esta es la facilidad que te digo, si quiero cambiar de pantalla solo tengo qure cambiar el route
sealed class AppScreen(val route:String) {
    //esta apunta a la primera funcion que es mi primera pantalla
    object FirstScreen:AppScreen("FirstScreen")
    //esta apunta a mi segunda funcion que es la segunda pantalla
    object SecondScreen:AppScreen("SecondScreen")
}