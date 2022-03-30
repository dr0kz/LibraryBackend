package com.stojanche.krstevski.librarybackend.api


import com.stojanche.krstevski.librarybackend.domain.Book
import com.stojanche.krstevski.librarybackend.domain.BookAuthorNotFound
import com.stojanche.krstevski.librarybackend.domain.BookCreated
import com.stojanche.krstevski.librarybackend.service.BookService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = ["*"])
class BookController(val bookService: BookService) {

    @GetMapping
    fun listAll(@RequestParam page: Int, @RequestParam pageSize: Int): ListBooksResponse =
        ListBooksResponse(this.bookService.listAll().size, this.bookService.listAllByPage(page, pageSize).toList())

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Book> =
        this.bookService.findById(id)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()


    @PostMapping("/add")
    fun createBook(@RequestBody bookRequest: BookRequest): ResponseEntity<BookResponse> =
        with(bookRequest) {
            when (val bookResult = bookService.createBook(name, category, authorId, availableCopies)) {
                is BookCreated -> ResponseEntity.ok(BookSuccess(bookResult.book))
                is BookAuthorNotFound -> ResponseEntity.badRequest().body(BookError("Book author not found"))
            }
        }

    @PutMapping("/edit")
    fun editBook(@RequestBody bookRequest: BookRequest) =
        with(bookRequest) {
            bookService.editBook(id!!, name, category, authorId, availableCopies)
        }

    @PutMapping("/markAsTaken/{id}")
    fun markBookAsTaken(@PathVariable id: Long) = bookService.markAsTaken(id)


    @DeleteMapping("/delete/{id}")
    fun deleteBook(@PathVariable id: Long) =
        this.bookService.deleteBook(id)
}