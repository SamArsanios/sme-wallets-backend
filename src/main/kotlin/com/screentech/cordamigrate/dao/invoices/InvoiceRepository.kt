package com.screentech.cordamigrate.dao.invoices

import com.screentech.cordamigrate.entity.invoices.Invoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
interface InvoiceRepository : JpaRepository<Invoice, Long>{

}
