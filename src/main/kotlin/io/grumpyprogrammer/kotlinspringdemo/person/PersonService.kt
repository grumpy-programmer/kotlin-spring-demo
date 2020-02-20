package io.grumpyprogrammer.kotlinspringdemo.person

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface PersonService {
    fun getAll(pageable: Pageable): Page<Person>

    fun getById(id: String): Optional<Person>

    fun create(person: Person): Person

    fun update(id: String, person: Person): Optional<Person>

    fun delete(id: String)
}