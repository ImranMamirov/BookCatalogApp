package com.example.bookcatalogapp.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.bookcatalogapp.ui.data.books
import com.example.bookcatalogapp.ui.screen.MainScreen
import com.example.bookcatalogapp.ui.screen.Screens
import com.example.bookcatalogapp.ui.screen.detail.DetailScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomNavHost()
        }
    }
}

@Composable
fun CustomNavHost() {
    var currentScreensState by remember { mutableStateOf<Screens>(Screens.Main) }

    when (currentScreensState) {
        is Screens.Main -> {
            MainScreen(
                books = books,
                navigate = {
                    currentScreensState = Screens.Detail(it)
                })
        }

        is Screens.Detail -> {
            val book = (currentScreensState as Screens.Detail).book
            DetailScreen(
                book,
                onBack = {
                    currentScreensState = Screens.Main
                }
            )
        }
    }
}