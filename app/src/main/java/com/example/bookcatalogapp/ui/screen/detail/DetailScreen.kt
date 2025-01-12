package com.example.bookcatalogapp.ui.screen.detail

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide
import com.example.bookcatalogapp.R
import com.example.bookcatalogapp.ui.data.Book

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(book: Book, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Book Info",
                    color = Color.White
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Black
            )
        )

        AndroidView(
            modifier = Modifier
                .padding(vertical = 30.dp)
                .size(200.dp),
            factory = { context ->
                ImageView(context).apply {
                    Glide.with(context)
                        .load(book.image)
                        .into(this)
                }
            }
        )

        Text(
            modifier = Modifier
                .padding(12.dp),
            text = book.name,
            fontSize = 24.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            modifier = Modifier
                .padding(12.dp),
            text = "by ${book.author}",
            fontSize = 18.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            modifier = Modifier
                .padding(12.dp),
            text = book.description,
            fontSize = 16.sp,
            fontFamily = FontFamily.Serif,
            color = Color.White
        )

        Button(
            modifier = Modifier
                .padding(12.dp),
            onClick = onBack,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            )
        ) {

            Image(
                modifier = Modifier
                    .padding(end = 12.dp),
                painter = painterResource(R.drawable.baseline_arrow_back_24),
                contentDescription = ""
            )

            Text(
                text = "Back",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DetailScreen_Preview() {
    DetailScreen(
        book = Book(
            name = "asd",
            author = "asd",
            description = "asd",
            image = "",
            ""
        ),
        onBack = {}
    )
}