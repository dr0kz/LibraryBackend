package com.stojanche.krstevski.librarybackend.api


import com.stojanche.krstevski.librarybackend.domain.Author
import com.stojanche.krstevski.librarybackend.service.AuthorService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/authors")
@CrossOrigin(origins = ["*"])
class AuthorController(val authorService: AuthorService) {

    @GetMapping
    fun getAuthors(): List<Author> = authorService.findAll()
}