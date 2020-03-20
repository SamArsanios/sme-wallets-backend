package com.screentech.cordamigrate.entity.ordernotifications

import com.screentech.cordamigrate.entity.order.Order
import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.entity.wallet.Wallet
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "order_notifications")
class OrderNotifications (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id : Long,
        @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "buyer_id") var buyer: User?,
        @OneToOne @JoinColumn(name = "wallets_id") var wallet: Wallet?,
        @OneToOne @JoinColumn(name = "order_id") var order: Order?,
        @Column(name = "type", columnDefinition = "text") var type : String?,
        @Column(name = "description", columnDefinition = "text") var description : String?,
        @Column(name = "title", columnDefinition = "text") var title : String?,
        @Column(name = "status", columnDefinition = "text") var status : String?,
        @Column(name = "the_timestamp", columnDefinition = "timestamp default now()") var timestamp: Timestamp? = getCurrentTimestampSQL(),
        @Transient var timestampStr : String?
)

