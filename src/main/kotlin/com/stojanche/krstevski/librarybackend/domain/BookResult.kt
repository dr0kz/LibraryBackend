package com.stojanche.krstevski.librarybackend.domain

sealed interface BookResult

data class BookCreated(val book: Book): BookResult
object BookAuthorNotFound: BookResult