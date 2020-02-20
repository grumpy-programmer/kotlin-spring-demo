package io.grumpyprogrammer.kotlinspringdemo.person

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonServiceImpl(val repository: PersonRepository, private val updater: PersonUpdater) : PersonService {

    override fun getAll(pageable: Pageable): Page<Person> {
        return repository.findAll(pageable)
    }

    override fun getById(id: String): Optional<Person> {
        return repository.findById(id)
    }

    override fun create(person: Person): Person {
        return repository.insert(person)
    }

    override fun update(id: String, person: Person): Optional<Person> {
        return getById(id)
                .map { updater.update(it, person) }
                .map { repository.save(it) }
    }

    override fun delete(id: String) {
        repository.deleteById(id)
    }
}