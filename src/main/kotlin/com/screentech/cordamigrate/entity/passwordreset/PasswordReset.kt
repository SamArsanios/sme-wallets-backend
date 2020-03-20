package com.screentech.cordamigrate.entity.passwordreset

import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "password_resets")
class PasswordReset (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id: Long?,
        @Column(name = "email", columnDefinition = "varchar(255) not null") var email: String,
        @Column(name = "token", columnDefinition = "text") var token: String,
        @Column(name = "create_at", columnDefinition = "timestamp default now()") var createAt: Timestamp?,
        @Transient var createAtStr: String?
)
