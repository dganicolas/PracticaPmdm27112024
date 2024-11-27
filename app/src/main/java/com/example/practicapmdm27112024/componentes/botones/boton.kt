package com.example.practicapmdm27112024.componentes.botones

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Boton(texto:String,onClick:() -> Unit,enabled:Boolean){
    Column {
        //un boton sin mas con la funcion on click y un texto y enabled por si acaso tengo que no se pueda pulsar
        Button(
            onClick = onClick,
            enabled = enabled
        ){
            Text(texto)
        }
    }
}