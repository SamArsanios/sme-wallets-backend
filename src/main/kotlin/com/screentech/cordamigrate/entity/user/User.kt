package com.screentech.cordamigrate.entity.user

import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Date
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name="users")
class User (

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id : Long?,

        @Column(name="email", columnDefinition = "varchar(255)") var email : String,
        @Column(name="email_verified_at", columnDefinition = "timestamp default now() not null") var emailVerifiedAt: Timestamp? = getCurrentTimestampSQL(),
        @Transient var emailVerifiedAtStr : String?,
        @Column(name="password", columnDefinition = "text") var  password : String,
        @Column(name="phone_number", columnDefinition = "varchar(255)") var phoneNumber : String,
        @Column(name="ref_user_id") var refUserId:BigDecimal,
        @Column(name = "name", columnDefinition = "text") var name:String,
        @Column(name = "user_type", columnDefinition = "varchar(255)") var userType : String

)
{
    override fun toString(): String {
        return "User(id=$id, email='$email', emailVerifiedAt=$emailVerifiedAt, emailVerifiedAtStr=$emailVerifiedAtStr, password='$password', phoneNumber='$phoneNumber', refUserId=$refUserId, name='$name')"
    }

}
