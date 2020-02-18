package com.screentech.cordamigrate.entity.securityquestion

import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.utility.getCurrentSQLDate
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Date
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "users_answers")
class UserAnswer (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id : Long,

        @ManyToMany(cascade = arrayOf(CascadeType.PERSIST, CascadeType.MERGE))
        @JoinTable(
                name = "useranswer_actualanswer_piv",
                joinColumns = arrayOf(JoinColumn(name = "user_answer_id", referencedColumnName = "id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "user_id", referencedColumnName = "id"))
                )
        var users: List<User> = mutableListOf<User>(),

        @ManyToOne(cascade = arrayOf(CascadeType.PERSIST))
        @JoinColumn(name = "question_id") var questionId : SecurityQuestion,
        @Column(name = "answer",columnDefinition = "text") var answer : BigDecimal,
        @Column(name = "the_timestamp", columnDefinition = "timestamp default now()") var timestamp : Timestamp? = getCurrentTimestampSQL(),
        @Transient var timestampStr : String?
)

{
    override fun toString(): String {
        return "UserAnswer(id=$id, users=$users, questionId=$questionId, answer=$answer, timestamp=$timestamp, timestampStr=$timestampStr)"
    }
}