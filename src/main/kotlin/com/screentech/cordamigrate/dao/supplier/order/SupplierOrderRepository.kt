package com.screentech.cordamigrate.dao.supplier.order

import com.screentech.cordamigrate.entity.supplier.order.SupplierOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
interface SupplierOrderRepository : JpaRepository<SupplierOrder,Long> {

//    fun findByEmail(email:String) : ResponseEntity<*>
}
