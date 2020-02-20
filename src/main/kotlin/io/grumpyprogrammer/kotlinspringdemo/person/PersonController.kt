package io.grumpyprogrammer.kotlinspringdemo.person

import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("people")
class PersonController(private val service: PersonService) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAll(@PageableDefault pageable: Pageable): List<Person> {
        return service.getAll(pageable).content
    }

    @GetMapping(path = ["{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getById(@PathVariable id: String): Optional<Person> = service.getById(id)

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody person: Person): Person = service.create(person)

    @PutMapping(path = ["{id}"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@PathVariable id: String, @RequestBody person: Person): Optional<Person> = service.update(id, person)

    @DeleteMapping(path = ["{id}"])
    fun delete(@PathVariable id: String): Unit = service.delete(id)
}