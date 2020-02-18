package com.screentech.cordamigrate.dao.passwordreset

import com.screentech.cordamigrate.entity.passwordreset.PasswordReset
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
interface PasswordResetRepository : JpaRepository<PasswordReset, Long> {

   fun findByEmail(email: String): ResponseEntity<*>

}
