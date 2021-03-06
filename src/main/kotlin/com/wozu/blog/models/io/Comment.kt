package com.wozu.blog.models.io

import com.fasterxml.jackson.annotation.JsonRootName
import com.wozu.blog.models.Users
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@JsonRootName("comment")
data class Comment(val createdAt: String,
                   val updatedAt: String,
                   val body: String,
                   val author: String,
                   val id: Long) {
    companion object {
        fun dateFormat(date: OffsetDateTime): String {
            return date.toZonedDateTime().
                withZoneSameInstant(ZoneId.of("Z")).
                format(DateTimeFormatter.ISO_ZONED_DATE_TIME)
        }

        fun fromModel(model: com.wozu.blog.models.Comment):
                Comment {
            return Comment(
                    id = model.id,
                    body = model.body,
                    createdAt = dateFormat(model.createdAt),
                    updatedAt = dateFormat(model.updatedAt),
                    author = model.author
            )
        }
    }
}