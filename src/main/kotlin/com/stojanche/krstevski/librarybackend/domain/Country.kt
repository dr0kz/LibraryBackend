package com.stojanche.krstevski.librarybackend.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name="countries")
data class Country(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    val name: String = "",
    val continent: String = "",
    @OneToMany(mappedBy = "country")
    @JsonBackReference
    val authors: List<Author> = ArrayList()
)
