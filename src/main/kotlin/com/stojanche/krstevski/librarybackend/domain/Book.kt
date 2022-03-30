package com.stojanche.krstevski.librarybackend.domain

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.stojanche.krstevski.librarybackend.domain.enum.Category
import javax.persistence.*


@Entity
@Table(name="books")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    val name: String="",
    @Enumerated(value = EnumType.STRING)
    val category: Category = Category.CLASSICS,
    @ManyToOne
    @JsonManagedReference
    val author: Author = Author(),
    val availableCopies: Int = 0,
)
