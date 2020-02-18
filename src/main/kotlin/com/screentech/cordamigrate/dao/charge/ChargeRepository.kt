package com.screentech.cordamigrate.dao.charge

import com.screentech.cordamigrate.entity.charges.Charge
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
interface ChargeRepository : JpaRepository<Charge, Long>{

}