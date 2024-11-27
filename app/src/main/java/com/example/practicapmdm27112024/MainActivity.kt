package com.example.practicapmdm27112024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigation.navegacion.AppNavigation
import com.example.practicapmdm27112024.ui.theme.PracticaPmdm27112024Theme


//justificacion de por que uso app navigation en el mismo archivo
// otras justificaciones en sus respectivos archivos
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticaPmdm27112024Theme {
                //pongo el scaffold para que el menu de navegacion y la barra de notificaciones me la respete y no este mi pantallas sobrepuesta en las mismas
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
