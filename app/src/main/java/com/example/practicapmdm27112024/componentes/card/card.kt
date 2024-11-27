package com.example.practicapmdm27112024.componentes.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CardString(texto:String?){
    OutlinedCard(
        //le pongo color a la carta
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        //le redondeo las esquinas
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        //le doy un ancho y un alto
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        if (texto != null) {
            Text(
                text = texto,
                //le pongo un padding para que se ajuste y no sobre salga
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp),
                textAlign = TextAlign.Center,
            )
        }
        else{
            //texto de error por defecto
            Text(
                text = "no hay datos para mostrar",
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp),
                textAlign = TextAlign.Center,
            )
        }
    }
}