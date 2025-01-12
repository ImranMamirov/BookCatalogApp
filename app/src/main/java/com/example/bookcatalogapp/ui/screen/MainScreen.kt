package com.example.bookcatalogapp.ui.screen

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.compose.GlideImage
import com.example.bookcatalogapp.R
import com.example.bookcatalogapp.ui.data.Book
import com.example.bookcatalogapp.ui.data.books

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    books: List<Book>,
    navigate: (Book) -> Unit
) {
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
                    text = "Book Catalog",
                    color = Color.White
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Black
            )
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            items(books.size) { index ->
                BookItem(
                    book = books[index],
                    onClick = {
                        navigate(books[index])
                    }
                )
            }
        }
    }
}

@Composable
fun BookItem(book: Book, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Gray),
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

        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                book.name,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "by ${book.author}",
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MainScreen_Preview() {
    MainScreen(
        books = listOf(
            Book(
                name = "Name Of Book",
                author = "Author",
                description = "",
                ""
            ),
            Book(
                name = "Name Of Book",
                author = "Author",
                description = "",
                ""
            )
        ),
        navigate = {}
    )
}