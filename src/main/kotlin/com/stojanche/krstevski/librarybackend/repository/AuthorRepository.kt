package com.stojanche.krstevski.librarybackend.repository

import com.stojanche.krstevski.librarybackend.domain.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository : JpaRepository<Author, Long>