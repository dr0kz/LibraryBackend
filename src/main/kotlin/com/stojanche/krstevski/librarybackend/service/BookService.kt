package com.stojanche.krstevski.librarybackend.service

import com.stojanche.krstevski.librarybackend.domain.Book
import com.stojanche.krstevski.librarybackend.domain.BookAuthorNotFound
import com.stojanche.krstevski.librarybackend.domain.BookCreated
import com.stojanche.krstevski.librarybackend.domain.BookResult
import com.stojanche.krstevski.librarybackend.domain.enum.Category
import com.stojanche.krstevski.librarybackend.repository.AuthorRepository
import com.stojanche.krstevski.librarybackend.repository.BookRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class BookService(val bookRepository: BookRepository, val authorRepository: AuthorRepository) {

    fun listAll(): List<Book> = this.bookRepository.findAll()

    fun listAllByPage(page: Int, pageSize: Int) = this.bookRepository.findAll(PageRequest.of(page, pageSize))

    fun findById(id: Long): Book? = this.bookRepository.findById(id).orElse(null)

    @Transactional
    fun createBook(name: String, category: Category, authorId: Long, availableCopies: Int ): BookResult {
        return try{
            val author = this.authorRepository.findById(authorId).orElseThrow { Exception() }
            val book = Book(name = name, category = category, author = author, availableCopies = availableCopies)
            BookCreated(this.bookRepository.save(book))
        }catch (ex : Exception){
            BookAuthorNotFound
        }
    }

    @Transactional
    fun editBook(id: Long, name: String, category: Category, authorId: Long, availableCopies: Int){
        val book = this.bookRepository.findById(id).orElse(null)
        val author = this.authorRepository.findById(authorId).orElse(null)
        if(book!=null && author!=null){
            this.bookRepository.update(id, name, category, author,availableCopies)
        }
    }

    @Transactional
    fun markAsTaken(id: Long){
        val book = this.bookRepository.findById(id).orElse(null)
        if(book!=null){
            this.bookRepository.markAsTaken(id)
        }
    }

    @Transactional
    fun deleteBook(id: Long){
        val book = this.bookRepository.findById(id).orElse(null)
        if(book!=null){
            this.bookRepository.delete(book)
        }
    }
}