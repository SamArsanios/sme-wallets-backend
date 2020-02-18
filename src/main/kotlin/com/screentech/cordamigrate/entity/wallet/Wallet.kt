package com.screentech.cordamigrate.entity.wallet

import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "wallets")
class Wallet(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id") var id : Long?,
        @Column(name = "name", columnDefinition = "text") var name : String?,
        @Column(name = "the_timestamp", columnDefinition = "timestamp default now()") var timestamp: Timestamp? = getCurrentTimestampSQL(),
        @ManyToOne(cascade = arrayOf(CascadeType.PERSIST))
        @JoinColumn(name = "user_id") var user : User?,
        @Transient var timestampStr:String? = ""

        ){

    override fun toString(): String {
        return "Wallet(id=$id, name=$name, timestamp=$timestamp, user=$user, timestampStr=$timestampStr)"
    }
}
