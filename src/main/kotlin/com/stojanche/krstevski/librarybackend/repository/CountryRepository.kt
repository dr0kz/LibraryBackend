package com.stojanche.krstevski.librarybackend.repository

import com.stojanche.krstevski.librarybackend.domain.Country
import org.springframework.data.jpa.repository.JpaRepository

interface CountryRepository : JpaRepository<Country, Long>