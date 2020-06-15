package com.wozu.blog.models

import org.jetbrains.annotations.Nullable
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
data class Users(
        var email: String = "",
        var password: String = "",
        var firstName: String = "",
        var lastName: String = "",
        var bio:String = "",
        var imageUrl: String = "",
        var socialLink: String = "",
        var isPaid: Boolean = false,
        var createdAt: OffsetDateTime = OffsetDateTime.now(),
        var updatedAt: OffsetDateTime = OffsetDateTime.now(),
        @OneToMany(mappedBy = "author")
        var articles: List<Article> = ArrayList<Article>(),
        @OneToMany(mappedBy = "commenter")
        var comments: List<Comment> = ArrayList<Comment>(),
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0) {

}