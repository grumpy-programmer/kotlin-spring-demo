package io.grumpyprogrammer.kotlinspringdemo.post

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class PostServiceImpl(val updater: PostUpdater, val repository: PostRepository) : PostService {
    override fun getAll(pageable: Pageable): Page<Post> {
        return repository.findAll(pageable)
    }

    override fun getById(id: String): Optional<Post> {
        return repository.findById(id)
    }

    override fun create(post: Post): Post {
        return repository.insert(post)
    }

    override fun update(id: String, post: Post): Optional<Post> {
        return getById(id)
                .map { updater.update(it, post) }
                .map { repository.save(it) }
    }

    override fun delete(id: String) {
        repository.deleteById(id)
    }
}