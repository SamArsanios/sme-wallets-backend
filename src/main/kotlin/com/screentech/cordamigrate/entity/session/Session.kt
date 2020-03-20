package com.screentech.cordamigrate.entity.session

import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "session")
class Session(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column( name  = "id") var id : Long,
        @OneToOne @JoinColumn(name = "user_id") var user : User,
        @Column(name = "ip_address", columnDefinition = "varchar(128)") var ipAddress : String,
        @Column(name = "user_agent", columnDefinition = "varchar(255)") var userAgent : String,
        @Column(name = "payload",columnDefinition = "text") var payload : String,
        @Column(name = "last_activity") var lastActivity : BigDecimal,
        @Column(name = "the_timestamp", columnDefinition = "timestamp default now()") var timestamp: Timestamp? = getCurrentTimestampSQL(),
        @Transient var timestampStr: String?
        ){

}
