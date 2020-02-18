package com.screentech.cordamigrate.dao.securityquestion

import com.screentech.cordamigrate.entity.securityquestion.SecurityQuestion
import org.springframework.data.jpa.repository.JpaRepository
import java.math.BigDecimal

interface SecurityQuestionRepository : JpaRepository<SecurityQuestion, Long> {

}