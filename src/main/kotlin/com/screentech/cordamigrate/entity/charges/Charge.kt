package com.screentech.cordamigrate.entity.charges

import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.entity.wallet.Wallet
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "charges")
class Charge(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)  @Column(name = "id") var id : Long,
        @Column(name = "withholding_tax", columnDefinition = "numeric(16,4)") var withHoldingTax : BigDecimal,
        @Column(name = "discount_amount", columnDefinition = "numeric(16,4)" ) var discountAmount : BigDecimal,
        @Column(name = "transaction_fees_supplier", columnDefinition = "numeric(16,4)") var transactionFeesSupplier : BigDecimal,
        @Column(name = "excise_duty_supplier", columnDefinition = "numeric(16,4)") var exciseDutySupplier : BigDecimal,
        @Column(name = "transaction_fees_sponsor", columnDefinition = "numeric(16,4)") var transactionFeesSponsor: BigDecimal,
        @Column(name = "excise_duty_sponsor", columnDefinition = "numeric(16,4)") var exciseDutySponsor: BigDecimal,
        @Column(name = "cbr", columnDefinition = "numeric(16,4)") var cbr : BigDecimal,
        @Column(name = "interest_rate", columnDefinition = "numeric(16,4)") var interestRate : BigDecimal,
        @Column(name = "the_timestamp", columnDefinition = "timestamp default now()") var timestamp: Timestamp? = getCurrentTimestampSQL(),
        @OneToOne(cascade = arrayOf(CascadeType.MERGE)) @OnDelete(action = OnDeleteAction.NO_ACTION) @JoinColumn(name = "user_id") var user: User,
        @OneToOne(cascade = arrayOf(CascadeType.MERGE)) @OnDelete(action = OnDeleteAction.NO_ACTION) @JoinColumn(name = "wallets_id") var wallet: Wallet,
        @Transient var timestampStr : String?
) {
}