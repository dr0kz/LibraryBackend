package com.stojanche.krstevski.librarybackend.configuration

import com.stojanche.krstevski.librarybackend.domain.Author
import com.stojanche.krstevski.librarybackend.domain.Book
import com.stojanche.krstevski.librarybackend.domain.Country
import com.stojanche.krstevski.librarybackend.domain.enum.Category
import com.stojanche.krstevski.librarybackend.repository.AuthorRepository
import com.stojanche.krstevski.librarybackend.repository.BookRepository
import com.stojanche.krstevski.librarybackend.repository.CountryRepository
import javax.annotation.PostConstruct

@org.springframework.context.annotation.Configuration
class Configuration(val bookRepository: BookRepository, val authorRepository: AuthorRepository, val countryRepository: CountryRepository) {
    @PostConstruct
    fun init(){
        val country : Country = countryRepository.save(Country(name="Macedonia", continent = "Europe"))
        val author: Author = authorRepository.save(Author(name="Alen", surname = "Petkov", country = country))
        authorRepository.save(Author(name="Ile", surname = "Petrofski", country = country))

        bookRepository.save(Book(name="Book1", category = Category.DRAMA, author = author, availableCopies = 10))

    }
}