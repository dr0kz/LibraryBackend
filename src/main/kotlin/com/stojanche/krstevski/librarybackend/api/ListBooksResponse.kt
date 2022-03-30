package com.stojanche.krstevski.librarybackend.api

import com.stojanche.krstevski.librarybackend.domain.Book

data class ListBooksResponse(val totalBooks: Int, val books: List<Book>)