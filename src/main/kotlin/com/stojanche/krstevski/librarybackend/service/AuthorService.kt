package com.stojanche.krstevski.librarybackend.service


import com.stojanche.krstevski.librarybackend.domain.Author
import com.stojanche.krstevski.librarybackend.repository.AuthorRepository
import org.springframework.stereotype.Service

@Service
class AuthorService(val authorRepository: AuthorRepository) {

    fun findAll() : List<Author> {
        val a: List<Author> = this.authorRepository.findAll()
        return a
    }
}