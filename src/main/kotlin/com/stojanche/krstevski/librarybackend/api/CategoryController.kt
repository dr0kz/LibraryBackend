package com.stojanche.krstevski.librarybackend.api

import com.stojanche.krstevski.librarybackend.domain.enum.Category
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = ["*"])
class CategoryController {

    @GetMapping
    fun getCategories() : List<Category> = Category.values().toList()
}