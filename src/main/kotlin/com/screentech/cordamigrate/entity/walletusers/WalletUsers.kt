package com.screentech.cordamigrate.entity.walletusers

import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.entity.wallet.Wallet
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "wallet_users")
class WalletUsers (
        @Id @GeneratedValue (strategy = GenerationType.IDENTITY) @Column(name = "id") var id : Long?,
        @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "buyer_id") var buyer: User?,
        @OneToOne @JoinColumn(name = "wallets_id") var wallet: Wallet?,
        @Column(name = "the_timestamp", columnDefinition = "timestamp default now()") var timestamp: Timestamp? = getCurrentTimestampSQL(),
        @Transient var timestampStr : String?
        )
