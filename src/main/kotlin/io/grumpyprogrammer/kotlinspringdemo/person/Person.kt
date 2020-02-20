package io.grumpyprogrammer.kotlinspringdemo.person

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

data class Person(
        @Id var id: String?,
        @CreatedDate var createdDate: LocalDateTime?,
        @LastModifiedDate var lastModifiedDate: LocalDateTime?,
        var name: String
)
