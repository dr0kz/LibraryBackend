package com.stojanche.krstevski.librarybackend.api

import com.stojanche.krstevski.librarybackend.domain.enum.Category

data class BookRequest(val id: Long?,val name: String, val category: Category, val authorId: Long, val availableCopies: Int)
