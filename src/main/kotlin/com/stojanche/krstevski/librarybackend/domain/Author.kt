package com.stojanche.krstevski.librarybackend.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name="authors")
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String = "",
    val surname: String = "",
    @ManyToOne
    @JsonManagedReference
    val country: Country = Country(),
    @OneToMany(mappedBy = "author")
    @JsonBackReference
    val books: List<Book> = ArrayList()
)
