package com.screentech.cordamigrate.dao.order

import com.screentech.cordamigrate.entity.order.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
interface OrderRepository : JpaRepository<Order, Long> {
    fun findByIsbnNumber(isbnNumberFormatException : String) : ResponseEntity<*>
}