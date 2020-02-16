package io.grumpyprogrammer.kotlinspringdemo.post

import org.springframework.data.mongodb.repository.MongoRepository

interface PostRepository : MongoRepository<Post, String> {
}