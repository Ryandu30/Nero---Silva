package com.example.nerosilva.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.nerosilva.presentation.nerosilvaapp.NeroSilvaApp
import dagger.hilt.android.AndroidEntryPoint

/* Jangan Lupa EntryPoint Jika Menggunakan DaggerHilt */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize()
            ) {
                NeroSilvaApp()
            }
        }
    }
}
