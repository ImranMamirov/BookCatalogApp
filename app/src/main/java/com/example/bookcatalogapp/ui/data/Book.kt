package com.example.bookcatalogapp.ui.data

data class Book(
    val name: String,
    val author: String,
    val description: String,
    val image: String = "",
    val category: String
)

var books = listOf(
    Book("The Catcher in the Rye", "J.D. Salinger", "A novel about the experiences of a young man named Holden Caulfield.", "https://covers.openlibrary.org/b/id/8222016-L.jpg", "Fiction"),
    Book("1984", "George Orwell", "A dystopian novel set in a totalitarian society controlled by Big Brother.", "https://covers.openlibrary.org/b/id/7222246-L.jpg", "Dystopia"),
    Book("To Kill a Mockingbird", "Harper Lee", "A story about racial injustice in the Deep South during the 1930s.", "https://covers.openlibrary.org/b/id/8278718-L.jpg", "Classic"),
    Book("The Great Gatsby", "F. Scott Fitzgerald", "A novel about the American Dream and the disillusionment of the Jazz Age.", "https://covers.openlibrary.org/b/id/8211760-L.jpg", "Classic"),
    Book("Pride and Prejudice", "Jane Austen", "A classic romantic novel set in the early 19th century in England.", "https://covers.openlibrary.org/b/id/7764869-L.jpg", "Romance"),
    Book("Moby-Dick", "Herman Melville", "A tale of a sea captain's obsession with capturing a giant white whale.", "https://covers.openlibrary.org/b/id/6872126-L.jpg", "Fiction"),
    Book("War and Peace", "Leo Tolstoy", "A historical novel that chronicles the Napoleonic Wars and Russian society.", "https://covers.openlibrary.org/b/id/7956106-L.jpg", "Classic"),
    Book("The Hobbit", "J.R.R. Tolkien", "A fantasy novel about the adventures of Bilbo Baggins and his journey with dwarves.", "https://covers.openlibrary.org/b/id/8599676-L.jpg", "Romance"),
    Book("Brave New World", "Aldous Huxley", "A dystopian novel about a world of genetically engineered happiness.", "https://covers.openlibrary.org/b/id/7323436-L.jpg", "Classic"),
    Book("Dracula", "Bram Stoker", "A Gothic novel about the vampire Count Dracula.", "https://covers.openlibrary.org/b/id/7868685-L.jpg", "Fiction"),
    Book("Frankenstein", "Mary Shelley", "A story of a scientist who creates a living being from body parts.", "https://covers.openlibrary.org/b/id/6474187-L.jpg", "Fiction"),
    Book("Dune", "Frank Herbert", "A science fiction novel set on the desert planet Arrakis.", "https://covers.openlibrary.org/b/id/7226806-L.jpg", "Romance"),
    Book("Emma", "Jane Austen", "A novel about a young woman who tries to play matchmaker.", "https://covers.openlibrary.org/b/id/7885854-L.jpg", "Romance"),
    Book("Dr. Jekyll and Mr. Hyde", "Robert Louis Stevenson", "A novella about the duality of human nature.", "https://covers.openlibrary.org/b/id/7902326-L.jpg", "Adventure"),
    Book("Gulliver's Travels", "Jonathan Swift", "A satirical novel about the adventures of Lemuel Gulliver.", "https://covers.openlibrary.org/b/id/7882275-L.jpg", "Fiction"),
    Book("Fahrenheit 451", "Ray Bradbury", "A dystopian novel about a future where books are banned.", "https://covers.openlibrary.org/b/id/7225459-L.jpg", "Adventure"),
    Book("The Trial", "Franz Kafka", "A surreal novel about a man who is arrested for an unknown crime.", "https://covers.openlibrary.org/b/id/7218999-L.jpg", "Romance"),
    Book("The Stranger", "Albert Camus", "A novel about the absurdity of life and existentialism.", "https://covers.openlibrary.org/b/id/7366340-L.jpg", "Adventure"),
    Book("The Old Man and the Sea", "Ernest Hemingway", "A story about an old fisherman battling a giant marlin.", "https://covers.openlibrary.org/b/id/7319191-L.jpg", "Dystopia")
)
val categories = listOf("All", "Fiction", "Dystopia", "Classic", "Romance", "Adventure")
