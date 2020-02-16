package io.grumpyprogrammer.kotlinspringdemo.post

import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(path = ["posts"])
class PostController(private val service: PostService) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAll(@PageableDefault pageable: Pageable): ResponseEntity<List<Post>> {
        val page = service.getAll(pageable)

        return ResponseEntity.ok()
                .header("Total-Elements", page.totalElements.toString())
                .body(page.content)
    }

    @GetMapping(path = ["{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getById(@PathVariable id: String): Optional<Post> {
        return service.getById(id)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(code = HttpStatus.CREATED)
    fun create(@RequestBody post: Post): Post {
        return service.create(post)
    }

    @PutMapping(path = ["{id}"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@PathVariable id: String, @RequestBody post: Post): Optional<Post> {
        return service.update(id, post)
    }

    @DeleteMapping(path = ["{id}"])
    fun delete(@PathVariable id: String) {
        service.delete(id)
    }
}