package com.wozu.blog.models.io

import com.fasterxml.jackson.annotation.JsonRootName
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@JsonRootName("article")
data class Article(var title: String? = null,
                   var description: String? = null,
                   var body: String? = null,
                   var slug: String = "",
                   var createdAt: String = "",
                   var updatedAt: String = "",
                   var author: String = "") {
    companion object {
        fun dateFormat(date: OffsetDateTime): String {
            return date.toZonedDateTime().withZoneSameInstant(ZoneId.of("Z")).format(DateTimeFormatter.ISO_ZONED_DATE_TIME)
        }

        fun fromModel(model: com.wozu.blog.models.Article): Article {
            return Article(
                    slug = model.slug,
                    title = model.title,
                    description = model.description,
                    body = model.body,
                    createdAt = dateFormat(model.createdAt),
                    updatedAt = dateFormat(model.updatedAt),
                    author = model.author)
        }
    }
}