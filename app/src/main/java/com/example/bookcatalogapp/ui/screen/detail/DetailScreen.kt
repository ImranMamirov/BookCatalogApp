package com.example.bookcatalogapp.ui.screen.detail

import android.widget.ImageView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.compose.GlideImage
import com.example.bookcatalogapp.ui.data.Book
import com.example.bookcatalogapp.ui.data.books

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(book: Book) {

    CenterAlignedTopAppBar(
        title = {
            Text(text = "Book Info")
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AndroidView(
            modifier = Modifier
                .size(100.dp),
            factory = { context ->
                ImageView(context).apply {
                    Glide.with(context)
                        .load(book.image)
                        .into(this)
                }
            }
        )

        Text(
            text = book.name,
            fontSize = 24.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold
        )

        Text(modifier = Modifier
            .padding(all = 12.dp),
            text = book.author,
            fontSize = 18.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = book.description,
            fontSize = 16.sp,
            fontFamily = FontFamily.Serif
        )
    }
}

@Composable
@Preview(showBackground = true)
fun DetailScreen_Preview() {
    DetailScreen(
        book = Book(
            name = "",
            author = "",
            description = "",
            image = ""
        )
    )
}