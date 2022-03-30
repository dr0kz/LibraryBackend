package com.stojanche.krstevski.librarybackend.repository

import com.stojanche.krstevski.librarybackend.domain.Author
import com.stojanche.krstevski.librarybackend.domain.Book
import com.stojanche.krstevski.librarybackend.domain.enum.Category
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface BookRepository : JpaRepository<Book, Long>{

    override fun findAll(pageable: Pageable): Page<Book>

    @Modifying
    @Query("update Book b set b.name = :name, b.category=:category, b.author= :author, b.availableCopies = :availableCopies" +
            " where b.id = :id")
    fun update(id: Long, name: String, category: Category, author: Author, availableCopies: Int): Int

    @Modifying
    @Query("update Book b set b.availableCopies = b.availableCopies-1 where b.id = :id")
    fun markAsTaken(id: Long)

}