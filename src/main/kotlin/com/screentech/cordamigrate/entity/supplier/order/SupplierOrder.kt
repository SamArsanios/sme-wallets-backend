package com.screentech.cordamigrate.entity.supplier.order

import com.screentech.cordamigrate.entity.order.Order
import com.screentech.cordamigrate.entity.user.User
import com.screentech.cordamigrate.utility.getCurrentDateFromJavaUtil
import com.screentech.cordamigrate.utility.getCurrentTimestampSQL
import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "supplier_order")
class SupplierOrder(
        
         @OneToOne(cascade = arrayOf(CascadeType.PERSIST)) @JoinColumn(name = "order_id") var order: Order,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id : Long,
        
        @Column(name = "price_per_item", columnDefinition = "decimal(15,8)") var pricePerItem: BigDecimal,
        @Column(name = "total_price", columnDefinition = "decimal(15,8)") var totalPrice: BigDecimal,
        @Column(name = "tax_rate", columnDefinition = "decimal(15,8)") var taxRate: BigDecimal,
        @Column(name = "shipping_charges", columnDefinition = "decimal(15,8)") var shippingCharges: BigDecimal,
        @Column(name = "sub_total", columnDefinition = "decimal(15,8)") var subTotal : BigDecimal,
        @Column(name = "final_total", columnDefinition = "decimal(15,8)") var finalTotal: BigDecimal,
        @Column(name = "status", columnDefinition = "varchar(255)") var status: String?,
        @Column(name = "the_timestamp", columnDefinition = "timestamp default now()") var timestamp: Timestamp? = getCurrentTimestampSQL(),
        @Transient var timestampStr: String?
)
