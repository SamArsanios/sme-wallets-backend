package com.screentech.cordamigrate.entity.walletlogos

import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.entity.wallet.Wallet
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.sql.Timestamp
import javax.persistence.*

class WalletLogos (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id : Long,
        @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") var buyer: User?,
        @Column(name="logo", columnDefinition = "text") var logo: String?,
        @Column(name = "the_timestamp", columnDefinition = "timestamp default now()") var timestamp: Timestamp? = getCurrentTimestampSQL(),
        @Transient var timestampStr : String?
)



