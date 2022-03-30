package com.stojanche.krstevski.librarybackend.api

import com.stojanche.krstevski.librarybackend.domain.Book

sealed interface BookResponse

data class BookSuccess(val book: Book) : BookResponse
data class BookError(val message: String) : BookResponse