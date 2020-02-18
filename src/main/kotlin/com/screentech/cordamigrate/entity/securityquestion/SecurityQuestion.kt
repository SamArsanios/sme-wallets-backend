package com.screentech.cordamigrate.entity.securityquestion

import java.sql.Date
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "security_questions")
class SecurityQuestion(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id: Long?,
        @Column(name = "question", columnDefinition = "text") var question: String?,
        @Column(name = "the_timestamp", columnDefinition = "timestamp default now()") var timestamp: Timestamp?,
        @Transient var timestampStr : String?
) {

    override fun toString(): String {
        return "SecurityQuestion(id=$id, question=$question, timestamp=$timestamp, timestampStr=$timestampStr)"
    }
}
