package io.grumpyprogrammer.kotlinspringdemo.person

import org.springframework.data.mongodb.repository.MongoRepository

interface PersonRepository : MongoRepository<Person, String>