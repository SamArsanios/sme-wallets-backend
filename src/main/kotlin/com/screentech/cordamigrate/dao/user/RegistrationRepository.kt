package com.screentech.cordamigrate.dao.user

import com.screentech.cordamigrate.entity.user.Registration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
interface RegistrationRepository : JpaRepository<Registration,Long>{
    fun findRegistrationByEmail(email : String) : Registration
}