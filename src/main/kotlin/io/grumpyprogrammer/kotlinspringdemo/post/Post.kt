package io.grumpyprogrammer.kotlinspringdemo.post

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "post")
data class Post(
        @Id var id: String?,
        @CreatedDate var createdDate: LocalDateTime?,
        @LastModifiedDate var lastModifiedDate: LocalDateTime?,
        var title: String,
        var content: String
)