package io.grumpyprogrammer.kotlinspringdemo.post

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget
import org.mapstruct.Mappings

@Mapper
interface PostUpdater {

    @Mappings(
            Mapping(target = "id", ignore = true),
            Mapping(target = "createdDate", ignore = true),
            Mapping(target = "lastModifiedDate", ignore = true)
    )
    fun update(@MappingTarget target: Post, source: Post): Post
}