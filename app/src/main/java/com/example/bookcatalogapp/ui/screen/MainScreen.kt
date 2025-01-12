package com.example.bookcatalogapp.ui.screen

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide
import com.example.bookcatalogapp.ui.data.Book
import com.example.bookcatalogapp.ui.data.categories

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    books: List<Book>,
    navigate: (Book) -> Unit
) {

    var selectedCategory by remember { mutableStateOf("All") }
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

    val filteredBooks = books.filter { book ->
        (selectedCategory == "All" || book.category == selectedCategory) &&
                (searchQuery.text.isEmpty() ||
                        book.name.contains(searchQuery.text, ignoreCase = true) ||
                        book.author.contains(searchQuery.text, ignoreCase = true))
    }

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

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = {
                Text(
                    text = "Search by title or Author",
                    color = Color.White
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Gray,
                cursorColor = Color.Black,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.LightGray,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.LightGray
            )
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories) { category ->
                CategoryChip(
                    category = category,
                    isSelected = category == selectedCategory,
                    onClick = { selectedCategory = category }
                )
            }
        }

        LazyColumn {
            items(filteredBooks) { book ->
                AnimatedContent(targetState = book) { animatedBook ->
                    BookItem(
                        book = animatedBook,
                        onClick = {
                            navigate(animatedBook)
                        }
                    )
                }
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
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                modifier = Modifier
                    .padding(vertical = 12.dp),
                text = "by ${book.author}",
                fontSize = 18.sp,
                color = Color.White
            )

            Text(
                text = book.category,
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun CategoryChip(category: String, isSelected: Boolean, onClick: () -> Unit) {

    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) Color.Gray else Color.DarkGray
    )

    Text(
        modifier = Modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp, horizontal = 16.dp),
        text = category,
        color = Color.White
    )
}


//@Composable
//@Preview(showBackground = true)
//fun MainScreen_Preview() {
//    MainScreen(
//        books = listOf(
//            Book(
//                name = "Name Of Book",
//                author = "Author",
//                description = "",
//                image = "",
//                category = "Category",
//            ),
//            Book(
//                name = "Name Of Book",
//                author = "Author",
//                description = "",
//                image = "",
//                category = "Category",
//            )
//        ),
//        navigate = {}
//    )
//}