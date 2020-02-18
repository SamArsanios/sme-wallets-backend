package com.screentech.cordamigrate.entity.invites

import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "invites")
class Invite(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id : Long,
        @ManyToOne(cascade = arrayOf(CascadeType.PERSIST), fetch = FetchType.LAZY) @JoinColumn(name = "user_id") var user: User,
        @Column(name = "invite_code") var inviteCode : String,
        @Column(name = "name", columnDefinition = "text") var name : String,
        @Column(name = "email") var email : String,
        @Column(name = "the_timestamp", columnDefinition = "timestamp default now()") var timestamp: Timestamp? = getCurrentTimestampSQL(),
        @Transient var timestampStr : String?
)