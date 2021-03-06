package com.wozu.blog.models

import java.time.OffsetDateTime
import javax.persistence.*

@Entity
data class Comment(var createdAt: OffsetDateTime = OffsetDateTime.now(),
                   var updatedAt: OffsetDateTime = OffsetDateTime.now(),
                   var body: String = "",
                   @ManyToOne
                   var article: Article = Article(),
                   var author: String = "",
                   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                   var id: Long = 0) {
}