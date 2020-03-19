package com.screentech.cordamigrate.entity.invoices

import com.screentech.cordamigrate.entity.order.Order
import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.entity.wallet.Wallet
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "invoices")
class Invoice (

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
        @OneToOne @JoinColumn(name = "order_id") var order : Order?,
        @OneToOne @JoinColumn(name = "sponsor_id") var sponsor: User?,
//        @OneToOne @JoinColumn(name = "wallet_id") var wallet: Wallet,
        @Column(name = "invoice_date", columnDefinition = "timestamp default now()") var invoiceDate: Timestamp? = getCurrentTimestampSQL(),
        @Column(name = "invoice_due_date", columnDefinition = "timestamp") var invoiceDueDate: Timestamp?,
        @Column(name = "invoice_status") var invoiceStatus: String?,
        @Column(name = "transaction_fee_percentage", columnDefinition = "numeric(16,4)") var transactionFeePercentage: BigDecimal?,
        @Column(name = "transaction_fees",columnDefinition = "numeric(16,4)") var transactionFees: BigDecimal?,
        @Column(name = "interest_rate",columnDefinition = "numeric(16,4)") var interestRate: BigDecimal?,
        @Column(name = "amount_to_pay",columnDefinition = "numeric(16,4)") var amountToPay : BigDecimal?,
        @Column(name = "withholding_amount",columnDefinition = "numeric(16,4)") var withHoldingAmount : BigDecimal?,
        @Column(name = "withholding_tax_percentage",columnDefinition = "numeric(16,4)") var withHoldingTaxPercentage: BigDecimal?,
        @Column(name = "notification_status",columnDefinition = "text") var notificationStatus : String?,
        @Column(name = "buyer_notification_status",columnDefinition = "text") var buyerNotificationStatus : String?,
        @Column(name = "decline_reason",columnDefinition = "text") var declineReason : String?,
        @Column(name = "get_paid", columnDefinition = "boolean") var getPaid : Boolean?,
        @Column(name = "authorize_status", columnDefinition = "boolean") var authorizeStatus : Boolean?,
        @Column(name = "sponsor_status", columnDefinition = "boolean") var sponsorStatus : Boolean?,
        @Column(name = "the_timestamp", columnDefinition = "timestamp") var theTimestamp: Timestamp?,

        @Transient var theTimestampStr : String?,
        @Transient var invoiceDateStr : String?,
        @Transient var invoiceDueDateStr : String?

)
