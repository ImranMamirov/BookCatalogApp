package com.example.bookcatalogapp.ui.screen

import com.example.bookcatalogapp.ui.data.Book

sealed class Screens {
    data object Main : Screens()
    data class Detail(val book: Book): Screens()
}