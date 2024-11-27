package com.example.practicapmdm27112024.componentes.camposTextos

import android.widget.EditText
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EditText(texto:String,textoEjemplo:String,textoEditText:String,onValueChange:(text:String) -> Unit,error:Boolean){
    Column {
        //campo de texto editable
        OutlinedTextField(
            //el valor del texto que va a mostrar
            value= textoEditText,
            //muestra si es un error lo que se ha introducido o no
            isError = error,
            //cada vez que se escribe en el el cambio que va a hacer
            onValueChange = onValueChange,
            //le muestro un texto arriba diciendo que parametro tiene que poner
            label= { Text(text = texto) },
            //texto fantasma de ejemplo
            placeholder = { Text(text = textoEjemplo) },
            //redondeo las esquinas para qeu se vea mas estetico
            shape = RoundedCornerShape(10.dp)
            )
    }
}