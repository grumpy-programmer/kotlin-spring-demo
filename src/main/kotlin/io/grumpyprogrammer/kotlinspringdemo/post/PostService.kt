package io.grumpyprogrammer.kotlinspringdemo.post

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface PostService {

    fun getAll(pageable: Pageable): Page<Post>

    fun getById(id: String): Optional<Post>

    fun create(post: Post): Post

    fun update(id: String, post: Post): Optional<Post>

    fun delete(id: String)
}