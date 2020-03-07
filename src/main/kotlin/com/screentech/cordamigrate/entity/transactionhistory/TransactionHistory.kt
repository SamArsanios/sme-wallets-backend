package com.screentech.cordamigrate.entity.transactionhistory

import com.screentech.cordamigrate.entity.invoices.Invoice
import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.entity.wallet.Wallet
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.*

class TransactionHistory(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id : Long,
        @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "invoice_id") var invoice: Invoice?,
        @OneToOne @JoinColumn(name = "wallets_id") var wallet: Wallet?,
        @Column(name="description", columnDefinition = "text") var description: String?,
        @Column(name="debits", columnDefinition = "decimal(15,8)") var debits: BigDecimal?,
        @Column(name="credits", columnDefinition = "decimal(15,8)") var credits: BigDecimal?,
        @Column(name="balance", columnDefinition = "decimal(15,8)") var balance: BigDecimal?,
        @Column(name = "the_timestamp", columnDefinition = "timestamp default now()") var timestamp: Timestamp? = getCurrentTimestampSQL(),
        @Transient var timestampStr : String?
)



